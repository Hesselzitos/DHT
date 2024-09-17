package com.ufabc.app.dht;

import com.ufabc.app.grpc.*;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DhtClient {
    private static final Logger logger = Logger.getLogger(DhtClient.class.getName());

    public static JOIN_OK joinRing(JOIN join,String nodePort){
        String target = join.getHashTableEntrant().getIP()+":"+nodePort;
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        DHTGrpc.DHTBlockingStub dhtBlockingStub = DHTGrpc.newBlockingStub(channel);
        String hashIdentifier = join.getHashTableEntrant().getHashIdentifier();
        logger.info("From "+hashIdentifier+ " trying to connect to the ring.");

        JOIN_OK joinOk = null;
        try {
            joinOk= dhtBlockingStub.joinRing(join);
            logger.log(Level.INFO,"From "+hashIdentifier+ " node connected to the ring, received:"+joinOk.toString());
        } catch (Exception e) {
            logger.log(Level.WARNING,e.getMessage());
        }
        return joinOk;
    }

    public static void sucessorAtualize(){
        String target = DhtServer.getSelfHashTable().getIP()+":"+DhtServer.getSelfHashTable().getPort();
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        DHTGrpc.DHTBlockingStub dhtBlockingStub = DHTGrpc.newBlockingStub(channel);
        String hashIdentifier = DhtServer.getSelfHashTable().getHashIdentifier();
        String sucessorHashIdentifier = DhtServer.getSucessorHashTable().getHashIdentifier();
        logger.info("From "+hashIdentifier+" trying to atualize the predecessor of my sucessor("+sucessorHashIdentifier+").");

        MessageReply messageReply = null;
        try {
            messageReply= dhtBlockingStub.sucessorAtualize(NEW_NODE.newBuilder().setHashTableEntrant(DhtServer.getSelfHashTable()).build());
            logger.log(Level.INFO,"From "+hashIdentifier+" "+messageReply.getAck());
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    public static void leaveRing(){
        String target = DhtServer.getPredecessorHashTable().getIP()+":"+DhtServer.getPredecessorHashTable().getPort();
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        DHTGrpc.DHTBlockingStub dhtBlockingStub = DHTGrpc.newBlockingStub(channel);
        String hashIdentifier = DhtServer.getSelfHashTable().getHashIdentifier();
        logger.info("From "+hashIdentifier+" trying to leave the ring");
        messageReceived messageReply;
        try {
            dhtBlockingStub.leaveRing(LEAVE.newBuilder().setHashTablePredecessor(DhtServer.getSucessorHashTable()).build());
            logger.log(Level.INFO,"From "+hashIdentifier+": leaved ring with sucess.");
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }
    public MessageReply transferItemResponsability(TRANSFER transfer){
        return MessageReply.newBuilder().build();
    }
}
