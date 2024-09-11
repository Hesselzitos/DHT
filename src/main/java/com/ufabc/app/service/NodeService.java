package com.ufabc.app.service;

import com.ufabc.app.dht.DhtServer;
import com.ufabc.app.grpc.HashTable;
import io.grpc.*;

import java.util.logging.Logger;

import static com.ufabc.app.dht.DhtServer.initializeServer;

public class NodeService {
    private static HashTable selfHashTable;
    private HashTable predecessorHashTable;
    private HashTable sucessorHashTable;
    private Server server;

    private static final Logger logger = Logger.getLogger(NodeService.class.getName());

    public static void initializeNode() {
        final DhtServer server = new DhtServer();
        server.start();
        server.blockUntilShutdown();
    }

}
