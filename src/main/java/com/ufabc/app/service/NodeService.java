package com.ufabc.app.service;

import com.ufabc.app.grpc.DHTGrpc;
import com.ufabc.app.grpc.HashTable;
import com.ufabc.app.grpc.JOIN;
import com.ufabc.app.grpc.JOIN_OK;
import io.grpc.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class NodeService {
    private static HashTable selfHashTable;
    private HashTable predecessorHashTable;
    private HashTable sucessorHashTable;
    private static String hashIdentifier;
    private static String ip = "127.0.0.1";
    private static String port;
    private Server server;

    private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());


    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                .addService(new DHTImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    NodeService.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    static class DHTImpl extends DHTGrpc.DHTImplBase {

        @Override
        public void joinRing(JOIN join) {
            HashTable hashTable = configureNode();
            JOIN_OK reply = JOIN.newBuilder().setHashTableEntrant(hashTable).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public static HashTable configureNode() {

        port = new Random().ints(49152, 65535).toString();
        hashIdentifier = hashIdentifierGenerate(ip + port);

        selfHashTable.toBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port);

        String line = FileService.readFile("ControleDHT.txt");


        ManagedChannel channel = Grpc.newChannelBuilder(ip+port, InsecureChannelCredentials.create())
                .build();
        if (line.isEmpty()) {
            //if empty, assume first node
        } else {

            //else read one and ask for predecessor

        }
        return selfHashTable;
    }

    public void initializeNode(String port){

    }

    public static String hashIdentifierGenerate(String textToHash) {
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

}
