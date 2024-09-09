package com.ufabc.app.service;

import com.ufabc.app.grpc.HashTable;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class NodeService {
    private HashTable selfHashTable;
    private HashTable predecessorHashTable;
    private HashTable sucessorHashTable;
    private String hashIdentifier;
    private String ip = "127.0.0.1";
    private String port;

    public void configureNode() {

        port = new Random().ints(49152, 65535).toString();
        hashIdentifier = this.hashIdentifierGenerate(ip + port);

        selfHashTable.toBuilder().setHashIdentifier(hashIdentifier).setIP(ip).setPort(port);

        String line = FileService.readFile("ControleDHT.txt");
        if (line.isEmpty()) {
            //if empty, assume first node
        } else {

            //else read one and ask for predecessor

        }
    }

    public void initializeNode(String port){
        ManagedChannel channel = Grpc.newChannelBuilder(this.ip+port, InsecureChannelCredentials.create())
                .build();

    }

    public String hashIdentifierGenerate(String textToHash) {
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
