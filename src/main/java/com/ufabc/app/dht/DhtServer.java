package com.ufabc.app.dht;

import com.ufabc.app.grpc.*;
import com.ufabc.app.service.FileService;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

import static com.ufabc.app.service.FileService.readControlDHTFile;
import static com.ufabc.app.service.FileService.ReWriteControlDHTFile;

public class DhtServer{
    private Server server;
    private static HashTable selfHashTable;
    private static HashTable predecessorHashTable;
    private static HashTable sucessorHashTable;

    private static final Map<Integer, Item> dataStore = new HashMap<>();

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
        logger.info("From "+selfHashTable.getHashIdentifier()+ " sucessor seted:"+sucessorHashTable.getHashIdentifier());
    }

    public static HashTable getPredecessorHashTable() {
        return predecessorHashTable;
    }

    public static void setPredecessorHashTable(HashTable predecessorHashTable) {
        DhtServer.predecessorHashTable = predecessorHashTable;
        logger.info("From "+selfHashTable.getHashIdentifier()+ " predecessor seted:"+predecessorHashTable.getHashIdentifier());
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
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            DhtClient.leaveRing();
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            DhtServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }


    public void stop() {
        if (server != null) {
            server.shutdown();

            try {
                if (!server.awaitTermination(30, TimeUnit.SECONDS)) {
                    System.out.println("*** Server didn't shut down in the expected time, forcing shutdown ***");
                    server.shutdownNow(); // Force shutdown if not all requests completed
                }
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
        int hashIdentifier = hashGenerate(ip + port);
        setSelfHashTable(HashTable.newBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port).build());
        setPredecessorHashTable(HashTable.newBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port).build());
        setSucessorHashTable(HashTable.newBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port).build());
    }

    public static int hashGenerate(String textToHash) {
        int hash = textToHash.hashCode();
        if (hash<0) return hash*(-1);
        return hash;
    }

     public static Boolean shouldAskNextNode(int requestKey){
         int selfHash = selfHashTable.getHashIdentifier();
         int sucessorHash = sucessorHashTable.getHashIdentifier();

         if(requestKey>selfHash){
             if(requestKey>sucessorHash){
                 return selfHash <= sucessorHash && selfHash != sucessorHash;
             } else return false;
         } else return requestKey < sucessorHash && selfHash != sucessorHash;
     }

    static class DHTImpl extends DHTGrpc.DHTImplBase{

        @Override
        public void joinRing(JOIN request, StreamObserver<JOIN_OK> responseObserver) {
            logger.info("From "+selfHashTable.getHashIdentifier()+" receiving join from "+request.getHashTableEntrant().getHashIdentifier());
            JOIN_OK joinOk;

            if(shouldAskNextNode(request.getHashTableEntrant().getHashIdentifier())){
                logger.info("From "+selfHashTable.getHashIdentifier()+" sending "+request.getHashTableEntrant().getHashIdentifier()+" to the next "+sucessorHashTable.getHashIdentifier());
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
            int predecessorHash = request.getHashTableEntrant().getHashIdentifier();
            setPredecessorHashTable(request.getHashTableEntrant());
            logger.info("From "+selfHashTable.getHashIdentifier()+" sending ack to "+getPredecessorHashTable());

            for(Map.Entry<Integer, Item> item : dataStore.entrySet()){
                if(predecessorHash<getSelfHashTable().getHashIdentifier() && predecessorHash>= item.getKey()){
                    DhtClient.transferItemResponsability(TRANSFER.newBuilder().setItemTransfer(item.getValue()).build());
                    dataStore.remove(item.getKey());
                } else if (selfHashTable.getHashIdentifier()< item.getKey()){
                    DhtClient.transferItemResponsability(TRANSFER.newBuilder().setItemTransfer(item.getValue()).build());
                    dataStore.remove(item.getKey());
                }
            }



            responseObserver.onNext(MessageReply
                    .newBuilder()
                    .setAck("From "+selfHashTable.getHashIdentifier()+" predecessor atualized to "+getPredecessorHashTable().getHashIdentifier())
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

        @Override
        public void store(Item request, StreamObserver<messageReceived> responseObserver) {
            int key = hashGenerate(request.getKeyItemHash());
            messageReceived messageReceived = null;
            if(shouldAskNextNode(key)){
                logger.info("From "+selfHashTable.getHashIdentifier()+" sending the store to the sucessor "+getSucessorHashTable().getHashIdentifier()+", item hash: "+key);
                messageReceived = DhtClient.store(request);
            } else{
                logger.info("From "+selfHashTable.getHashIdentifier()+" storing the item with the hash: "+key);
                dataStore.put(key, request);
                messageReceived = messageReceived.newBuilder().build();
            }
            responseObserver.onNext(messageReceived);
            responseObserver.onCompleted();
        }

        @Override
        public void retrive(Item request, StreamObserver<Item> responseObserver) {
            int key = hashGenerate(request.getKeyItemHash());
            Item itemResponse;
            if(shouldAskNextNode(key)){
                logger.info("From "+selfHashTable.getHashIdentifier()+" sending the retrive to the sucessor "+getSucessorHashTable().getHashIdentifier()+", item hash: "+key);
                itemResponse = DhtClient.retrive(request);
            } else{
                logger.info("From "+selfHashTable.getHashIdentifier()+" retriving the item with the hash: "+key);
                itemResponse=dataStore.get(key);
            }
            responseObserver.onNext(itemResponse);
            responseObserver.onCompleted();
        }

        @Override
        public void transferItemResponsability(TRANSFER transfer, StreamObserver<MessageReply> responseObserver) {
            int key = hashGenerate(transfer.getItemTransfer().getKeyItemHash());
            MessageReply messageReply = null;
            if(shouldAskNextNode(key)){
                logger.info("From "+selfHashTable.getHashIdentifier()+" sending the retrive to the sucessor "+getSucessorHashTable().getHashIdentifier()+", item hash: "+key);
                messageReply = DhtClient.transferItemResponsability(transfer);
            } else{
                dataStore.put(key, transfer.getItemTransfer());
                messageReply = MessageReply.newBuilder().setAck("Trnasfer received in "+selfHashTable.getHashIdentifier()).build();
                logger.info("From "+selfHashTable.getHashIdentifier()+" receving the transfer for the item with the hash: "+key);
            }
            responseObserver.onNext(messageReply);
            responseObserver.onCompleted();
        }
    }
}
