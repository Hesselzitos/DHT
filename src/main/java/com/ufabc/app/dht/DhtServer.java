package com.ufabc.app.dht;

import com.ufabc.app.grpc.*;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.ufabc.app.service.FileService.readControlDHTFile;
import static com.ufabc.app.service.FileService.ReWriteControlDHTFile;

public class DhtServer{
    private io.grpc.Server server;
    private static HashTable selfHashTable;
    private static HashTable predecessorHashTable;
    private static HashTable sucessorHashTable;

    private static final Logger logger = Logger.getLogger(DhtServer.class.getName());

    public DhtServer() {}
    public DhtServer(Server server) {
        this.server = server;
    }

    public static HashTable getSucessorHashTable() {
        return sucessorHashTable;
    }

    public static void setSucessorHashTable(HashTable sucessorHashTable) {
        DhtServer.sucessorHashTable = sucessorHashTable;
        logger.info("From "+selfHashTable.getHashIdentifier()+ "Sucessor seted:"+sucessorHashTable.getHashIdentifier());
    }

    public static HashTable getPredecessorHashTable() {
        return predecessorHashTable;
    }

    public static void setPredecessorHashTable(HashTable predecessorHashTable) {
        DhtServer.predecessorHashTable = predecessorHashTable;
        logger.info("From "+selfHashTable.getHashIdentifier()+ "Predecessor seted:"+predecessorHashTable.getHashIdentifier());
    }

    public static HashTable getSelfHashTable() {
        return selfHashTable;
    }

    public static void setSelfHashTable(HashTable selfHashTable) {
        DhtServer.selfHashTable = selfHashTable;
    }



    public void start() {
        /* The port on which the server should run */
        initializeServer();
        int port = Integer.parseInt(selfHashTable.getPort());
        try {
            server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                    .addService(new DHTImpl())
                    .build()
                    .start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("Server started, listening on " + port);
        logger.info("\nInformacoes do Node: \n" + selfHashTable.toString());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                DhtServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }


    public void stop() {
        if (server != null) {
            try {
                server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void blockUntilShutdown() {
        if (server != null) {
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public static void initializeServer() {
        configureNode();
        ArrayList<String> dhtNodes = readControlDHTFile();
        String port = selfHashTable.getPort();
        while(dhtNodes.contains(port)){
            configureNode();
            port = selfHashTable.getPort();
        }
        dhtNodes.add(port);
        ReWriteControlDHTFile(dhtNodes);
    }

    private static void configureNode() {
        logger.info("Configuring node properties");
        String port = String.valueOf(new Random().ints(49152, 65535).findFirst().getAsInt());
        String ip = "127.0.0.1";
        String hashIdentifier = hashIdentifierGenerate(ip + port);
        setSelfHashTable(HashTable.newBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port).build());
        setPredecessorHashTable(HashTable.newBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port).build());
        setSucessorHashTable(HashTable.newBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port).build());
    }

    public static String hashIdentifierGenerate(String textToHash) {
        // Get an instance of SHA-256 digest
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");


            // Generate the hash as a byte array
            byte[] encodedhash = digest.digest(textToHash.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
     public static Boolean shouldAskNextNode(int requestKey){
         int selfPort = Integer.parseInt(selfHashTable.getPort());
         int sucessorPort = Integer.parseInt(sucessorHashTable.getPort());

         if(requestKey>selfPort){
             if(requestKey>sucessorPort){
                 return selfPort <= sucessorPort && selfPort != sucessorPort;
             } else return false;
         } else return requestKey < sucessorPort && selfPort != sucessorPort;
     }

    static class DHTImpl extends DHTGrpc.DHTImplBase{

        @Override
        public void joinRing(JOIN request, StreamObserver<JOIN_OK> responseObserver) {
            logger.info("From "+selfHashTable.getHashIdentifier()+" receiving join from "+request.getHashTableEntrant().getHashIdentifier());
            JOIN_OK joinOk;

            if(shouldAskNextNode(Integer.parseInt(request.getHashTableEntrant().getPort()))){
                logger.info("From "+selfHashTable.getHashIdentifier()+" sending to the next "+sucessorHashTable.getHashIdentifier());
                joinOk = DhtClient.joinRing(request,sucessorHashTable.getPort());

            } else {joinOk = JOIN_OK
                    .newBuilder()
                    .setHashTablePredecessor(selfHashTable)
                    .setHashTableSucessor(sucessorHashTable)
                    .build();
                setSucessorHashTable(request.getHashTableEntrant());
            }
            responseObserver.onNext(joinOk);
            responseObserver.onCompleted();
        }

        @Override
        public void sucessorAtualize(NEW_NODE request, StreamObserver<MessageReply> responseObserver) {
            setPredecessorHashTable(request.getHashTableEntrant());
            responseObserver.onNext(MessageReply
                    .newBuilder()
                    .setAck("From "+selfHashTable.getHashIdentifier()+" predecessor atualized to "+predecessorHashTable.getHashIdentifier())
                    .build());
            responseObserver.onCompleted();
        }
        @Override
        public void leaveRing(LEAVE leave, StreamObserver<messageReceived> responseObserver){
            setSucessorHashTable(leave.getHashTablePredecessor());
            DhtClient.sucessorAtualize();
            responseObserver.onNext(messageReceived.newBuilder().build());
            responseObserver.onCompleted();
        }
    }
}
