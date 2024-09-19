package com.ufabc.app.dht;

import com.ufabc.app.grpc.*;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.ufabc.app.dht.DhtServer.getSelfHashTable;

public class DhtClient {
    private static final Logger logger = Logger.getLogger(DhtClient.class.getName());

    public static JOIN_OK joinRing(JOIN join,String nodePort){
        String target = join.getHashTableEntrant().getIP()+":"+nodePort;
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        DHTGrpc.DHTBlockingStub dhtBlockingStub = DHTGrpc.newBlockingStub(channel);
        int hashIdentifier = join.getHashTableEntrant().getHashIdentifier();
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
        String target = DhtServer.getSucessorHashTable().getIP()+":"+ DhtServer.getSucessorHashTable().getPort();
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        DHTGrpc.DHTBlockingStub dhtBlockingStub = DHTGrpc.newBlockingStub(channel);
        int hashIdentifier = getSelfHashTable().getHashIdentifier();
        int sucessorHashIdentifier = DhtServer.getSucessorHashTable().getHashIdentifier();
        logger.info("From "+hashIdentifier+" trying to atualize the predecessor of my sucessor("+sucessorHashIdentifier+").");

        MessageReply messageReply = null;
        try {
            messageReply= dhtBlockingStub.sucessorAtualize(NEW_NODE.newBuilder().setHashTableEntrant(getSelfHashTable()).build());
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
        int hashIdentifier = getSelfHashTable().getHashIdentifier();
        logger.info("From "+hashIdentifier+" trying to leave the ring");
        messageReceived messageReply;
        try {
            dhtBlockingStub.leaveRing(LEAVE.newBuilder().setHashTablePredecessor(DhtServer.getSucessorHashTable()).build());
            logger.log(Level.INFO,"From "+hashIdentifier+": leaved ring with sucess.");
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    public static messageReceived store(Item item) {
        String target = DhtServer.getSucessorHashTable().getIP()+":"+ DhtServer.getSucessorHashTable().getPort();
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        DHTGrpc.DHTBlockingStub dhtBlockingStub = DHTGrpc.newBlockingStub(channel);
        int hashIdentifier = getSelfHashTable().getHashIdentifier();
        int sucessorHashIdentifier = DhtServer.getSucessorHashTable().getHashIdentifier();
        logger.info("From "+hashIdentifier+" trying to store in the sucessor("+sucessorHashIdentifier+").");

        messageReceived messageReply = null;
        try {
            messageReply= dhtBlockingStub.store(item);
            logger.log(Level.INFO,"From "+hashIdentifier+" item stored.");
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
        return messageReply;
    }

    public static Item retrive(Item request) {
        return Item.newBuilder().build();
    }

    public static MessageReply transferItemResponsability(TRANSFER transfer){
        String target = DhtServer.getSucessorHashTable().getIP()+":"+ DhtServer.getSucessorHashTable().getPort();
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        DHTGrpc.DHTBlockingStub dhtBlockingStub = DHTGrpc.newBlockingStub(channel);
        int hashIdentifier = getSelfHashTable().getHashIdentifier();
        int sucessorHashIdentifier = DhtServer.getSucessorHashTable().getHashIdentifier();
        logger.info("From "+hashIdentifier+" trying to transfer the item to the sucessor("+sucessorHashIdentifier+").");
        MessageReply messageReply = null;
        try {
            messageReply= dhtBlockingStub.transferItemResponsability(transfer);
            logger.log(Level.INFO,"From "+hashIdentifier+" item transferred.");
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
        return messageReply;
    }
}
