package com.ufabc.app.dht;

import com.ufabc.app.grpc.*;
import com.ufabc.app.service.FileService;
import io.grpc.Channel;

import java.util.ArrayList;
import java.util.logging.Logger;

public class DhtClient {
    private static DHTGrpc.DHTBlockingStub dhtBlockingStub;

    private static final Logger logger = Logger.getLogger(DhtClient.class.getName());

    public DhtClient(Channel channel) {
        dhtBlockingStub = DHTGrpc.newBlockingStub(channel);
    }

    public static JOIN_OK joinRing(JOIN join){
        String hashIdentifier = join.getHashTableEntrant().getHashIdentifier();
        logger.info("Trying to connect to the ring the node "+hashIdentifier);
        return dhtBlockingStub.joinRing(join);
    }
    public MessageReply sucessorAtualize(NEW_NODE newNode){
        return MessageReply.newBuilder().build();
    }
    public MessageReply transferItemResponsability(TRANSFER transfer){
        return MessageReply.newBuilder().build();
    }
}
