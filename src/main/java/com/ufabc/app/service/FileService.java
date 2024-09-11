package com.ufabc.app.service;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileService {
    private static final String csvFile = "ControleDHT.csv";
    private static final String delimiter = ";";

    private static final Logger logger = Logger.getLogger(FileService.class.getName());


    public static List<String> readControlDHTFile() {
        List<String> values = Collections.singletonList("");
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine(); // Read the second line
            if (line != null) {
                values = Arrays.asList(line.split(delimiter));
            }
            logger.info(csvFile+" read with sucess.");
        } catch (IOException e) {
            logger.log(Level.SEVERE,csvFile+" read failed. \n"+e.getMessage());
            throw new RuntimeException(e);
        }
        return values;
    }

    public static void writeControlDHTFile(List<String> dhtNodes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            String line = String.join(delimiter, dhtNodes);
            writer.write(line);
            logger.info(csvFile+" writed with sucess.");
        } catch (IOException e) {
            logger.log(Level.SEVERE,csvFile+" read failed. \n"+e.getMessage());
        }
    }

}
