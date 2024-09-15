package com.ufabc.app.dht;

import com.ufabc.app.grpc.HashTable;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DhtServerTest {

    @ParameterizedTest
    @CsvSource({
            "1,1,1,true",
            "1,1,2,false",
            "2,1,5,false",
            "1,2,5,true"
    })
    void shouldAskNextNode(String selfPort, String sucessorPort, String entrantPort, Boolean expected) {
        Server server = Grpc.newServerBuilderForPort(Integer.parseInt(selfPort), InsecureServerCredentials.create())
                .addService(new DhtServer.DHTImpl())
                .build();
        DhtServer dhtServer = new DhtServer(server);

        dhtServer.setSucessorHashTable(HashTable.newBuilder().setPort(sucessorPort).build());
        dhtServer.setSelfHashTable(HashTable.newBuilder().setPort(selfPort).build());

        assertEquals(expected,DhtServer.shouldAskNextNode(Integer.parseInt(entrantPort)));
    }
}