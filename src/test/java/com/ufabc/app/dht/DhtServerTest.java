package com.ufabc.app.dht;

import com.ufabc.app.grpc.HashTable;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DhtServerTest {

    @ParameterizedTest
    @CsvSource({
            "1,1,1,false",
            "1,1,2,false",
            "2,1,5,false",
            "1,2,5,true",
            "5,2,4,false",
            "5,5,6,false",
            "5,5,4,false"
    })
    void shouldAskNextNode(int selfHash, int sucessorHash, int entrantHash, Boolean expected) {
        Server server = Grpc.newServerBuilderForPort(selfHash, InsecureServerCredentials.create())
                .addService(new DhtServer.DHTImpl())
                .build();
        DhtServer dhtServer = new DhtServer(server);
        dhtServer.setSelfHashTable(HashTable.newBuilder().setHashIdentifier(selfHash).setHashIdentifier(selfHash).build());
        dhtServer.setSucessorHashTable(HashTable.newBuilder().setHashIdentifier(entrantHash).setHashIdentifier(sucessorHash).build());

        assertEquals(expected,DhtServer.shouldAskNextNode(entrantHash));
    }
}