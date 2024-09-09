package com.ufabc.app.dht;

import com.ufabc.app.grpc.*;
import io.grpc.Channel;

import java.util.logging.Logger;

public abstract class Node {
    private static final Logger logger = Logger.getLogger(Node.class.getName());

    private final DHTGrpc.DHTBlockingStub blockingStub;

    protected Node(Channel channel) {
        blockingStub = DHTGrpc.newBlockingStub(channel);
    }

    abstract JOIN_OK joinRing(JOIN join);
    abstract MessageReply sucessorAtualize(NEW_NODE newNode);
    abstract MessageReply transferItemResponsability(TRANSFER transfer);
}
