package com.ufabc.app.service;

import com.ufabc.app.dht.DhtClient;
import com.ufabc.app.dht.DhtServer;
import com.ufabc.app.grpc.HashTable;
import com.ufabc.app.grpc.JOIN;
import com.ufabc.app.grpc.JOIN_OK;
import io.grpc.*;

import java.util.ArrayList;
import java.util.logging.Logger;

public class NodeService {
    private static HashTable selfHashTable;
    private static HashTable predecessorHashTable;
    private static HashTable sucessorHashTable;

    private static final Logger logger = Logger.getLogger(NodeService.class.getName());

    public static void initializeNode() {
        final DhtServer server = new DhtServer();
        server.start();
        selfHashTable = DhtServer.getSelfHashTable();
        ArrayList<String> nodes = FileService.readControlDHTFile();
        if(nodes.size()==1){
            predecessorHashTable = selfHashTable;
            sucessorHashTable = selfHashTable;
        } else {
                nodes.remove(selfHashTable.getPort());
                String target = selfHashTable.getIP()+":"+nodes.get(0);
                ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                    .build();
                DhtClient dhtClient = new DhtClient(channel);
                JOIN join = JOIN.newBuilder().setHashTableEntrant(selfHashTable).build();
                JOIN_OK joinOk= dhtClient.joinRing(join);
                predecessorHashTable = joinOk.getHashTablePredecessor();
                sucessorHashTable = joinOk.getHashTableSucessor();
            logger.info("Predecessor seted:"+predecessorHashTable.getHashIdentifier());
            logger.info("Sucessor seted:"+sucessorHashTable.getHashIdentifier());
            }
        server.blockUntilShutdown();
        }
    }

