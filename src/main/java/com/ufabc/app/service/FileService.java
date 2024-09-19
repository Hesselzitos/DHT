package com.ufabc.app.service;

import com.ufabc.app.dht.DhtServer;
import com.ufabc.app.grpc.Item;
import com.ufabc.app.grpc.messageReceived;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileService {
    private static final String csvFile = "ControleDHT.csv";
    private static final String csvFileTable = String.valueOf(DhtServer.getSelfHashTable().getHashIdentifier()) +"-table.csv";
    private static final String delimiter = ";";

    private static final Logger logger = Logger.getLogger(FileService.class.getName());


    public static ArrayList<String> readControlDHTFile() {
        ArrayList<String> values = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine(); // Read the second line
            if (line != null) {
                values = new ArrayList<String>(Arrays.asList(line.split(delimiter)));
            }
            logger.info(csvFile+" read with sucess.");
        } catch (IOException e) {
            logger.log(Level.INFO,csvFile+" read failed. \n"+e.getMessage());
        }
        return values;
    }
//    public static Item readItemFile(String hash) {
//        String fileItemName = hash+csvFileTable;
//        String line = "";
//        try (BufferedReader br = new BufferedReader(new FileReader(fileItemName))) {
//            line = br.readLine(); // Read the second line
//            logger.info(fileItemName+" read with sucess.");
//        } catch (IOException e) {
//            logger.log(Level.INFO,fileItemName+" read failed. \n"+e.getMessage());
//        }
//        return Item.newBuilder().setKeyItemHash(hash).setValueItem(line).build();
//    }

    public static void ReWriteControlDHTFile(ArrayList<String> dhtNodes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            String line = String.join(delimiter, dhtNodes);
            writer.write(line);
            logger.info(csvFile+" writed with sucess.");
        } catch (IOException e) {
            logger.log(Level.SEVERE,csvFile+" write failed. \n"+e.getMessage());
        }
    }

//    public static messageReceived store(Item item) {
//        String hash = item.getKeyItemHash();
//        String fileItemName = hash+csvFileTable;
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileItemName))) {
//            writer.write(item.getValueItem().toString());
//            logger.info(fileItemName+" writed with sucess.");
//        } catch (IOException e) {
//            logger.log(Level.SEVERE,fileItemName+" write failed. \n"+e.getMessage());
//        }
//        return messageReceived.newBuilder().build();
//    }
}
