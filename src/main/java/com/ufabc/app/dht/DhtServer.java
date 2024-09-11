package com.ufabc.app.dht;

import com.ufabc.app.grpc.*;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.ufabc.app.service.FileService.readControlDHTFile;
import static com.ufabc.app.service.FileService.writeControlDHTFile;

public class DhtServer{
    private io.grpc.Server server;
    private static HashTable selfHashTable;

    private static final Logger logger = Logger.getLogger(DhtServer.class.getName());

//    public JOIN_OK joinRing(JOIN join){
//        return JOIN_OK.newBuilder().build();
//    }
//    public MessageReply sucessorAtualize(NEW_NODE newNode){
//        return MessageReply.newBuilder().setAck("ok").build();
//    }
//    public MessageReply transferItemResponsability(TRANSFER transfer){
//        return MessageReply.newBuilder().setAck("ok").build();
//
//    }


    public void start() {
        /* The port on which the server should run */
        initializeServer();
        int port = selfHashTable.getPort();
        try {
            server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                    .addService(new DHTImpl())
                    .build()
                    .start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("Server started, listening on " + port);
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
        List<String> dhtNodes = readControlDHTFile();
        String hashIdentifier = selfHashTable.getHashIdentifier();
        while(dhtNodes.contains(hashIdentifier) || !selfHashTable.isInitialized())configureNode();
        dhtNodes.add(hashIdentifier);
        writeControlDHTFile(dhtNodes);
    }

    private static void configureNode() {
        logger.info("Configuring node properties");
        int port = new Random().ints(49152, 65535).findFirst().getAsInt();
        String ip = "127.0.0.1";
        String hashIdentifier = hashIdentifierGenerate(ip + port);
        selfHashTable.toBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port);
    }

    private static String hashIdentifierGenerate(String textToHash) {
        // Get an instance of SHA-256 digest
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");


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

    static class DHTImpl extends DHTGrpc.DHTImplBase{

    }
}
