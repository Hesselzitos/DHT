package com.ufabc.app.service;

import com.ufabc.app.dht.DhtClient;
import com.ufabc.app.dht.DhtServer;
import com.ufabc.app.grpc.HashTable;
import com.ufabc.app.grpc.JOIN;
import com.ufabc.app.grpc.JOIN_OK;
import io.grpc.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NodeService {
    private static HashTable selfHashTable;
    private static final DhtServer server= new DhtServer();

    private static final Logger logger = Logger.getLogger(NodeService.class.getName());

    public static void initializeNode() {
        server.start();
        selfHashTable = DhtServer.getSelfHashTable();
        tryJoinRing();
        server.blockUntilShutdown();
    }

    private static void tryJoinRing() {
        ArrayList<String> nodes = FileService.readControlDHTFile();
        while (!nodes.isEmpty()) {
            JOIN join = JOIN.newBuilder().setHashTableEntrant(selfHashTable).build();
            JOIN_OK joinOk= DhtClient.joinRing(join,nodes.getFirst());
            if(joinOk!=null){
                server.setPredecessorHashTable(joinOk.getHashTablePredecessor());
                server.setSucessorHashTable(joinOk.getHashTableSucessor());
                break;
            } else nodes.removeFirst();

        }
        logger.info("Predecessor seted:"+server.getPredecessorHashTable().getHashIdentifier());
        logger.info("Sucessor seted:"+server.getSucessorHashTable().getHashIdentifier());
    }

}

