// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/DHT.proto

// Protobuf Java Version: 3.25.1
package com.ufabc.app.grpc;

public interface RETRIEVEOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RETRIEVE)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 keyItemHash = 1;</code>
   * @return The keyItemHash.
   */
  long getKeyItemHash();

  /**
   * <code>.HashTable hashTableIdentifier = 2;</code>
   * @return Whether the hashTableIdentifier field is set.
   */
  boolean hasHashTableIdentifier();
  /**
   * <code>.HashTable hashTableIdentifier = 2;</code>
   * @return The hashTableIdentifier.
   */
  com.ufabc.app.grpc.HashTable getHashTableIdentifier();
  /**
   * <code>.HashTable hashTableIdentifier = 2;</code>
   */
  com.ufabc.app.grpc.HashTableOrBuilder getHashTableIdentifierOrBuilder();
}
