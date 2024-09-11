package com.ufabc.app.dht;

import com.ufabc.app.grpc.*;
import io.grpc.Channel;

import java.util.logging.Logger;

public class Client extends Node{
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    protected Client(Channel channel) {
        super(channel);
    }

    public JOIN_OK joinRing(JOIN join){

        return JOIN_OK.newBuilder().build();
    }
    public MessageReply sucessorAtualize(NEW_NODE newNode){
        return MessageReply.newBuilder().build();
    }
    public MessageReply transferItemResponsability(TRANSFER transfer){
        return MessageReply.newBuilder().build();
    }
}