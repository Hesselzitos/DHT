// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/DHT.proto

// Protobuf Java Version: 3.25.1
package com.ufabc.app.grpc;

public interface JOIN_OKOrBuilder extends
    // @@protoc_insertion_point(interface_extends:JOIN_OK)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.hashTable hashTablePredecessor = 1;</code>
   * @return Whether the hashTablePredecessor field is set.
   */
  boolean hasHashTablePredecessor();
  /**
   * <code>.hashTable hashTablePredecessor = 1;</code>
   * @return The hashTablePredecessor.
   */
  com.ufabc.app.grpc.hashTable getHashTablePredecessor();
  /**
   * <code>.hashTable hashTablePredecessor = 1;</code>
   */
  com.ufabc.app.grpc.hashTableOrBuilder getHashTablePredecessorOrBuilder();

  /**
   * <code>.hashTable hashTableSucessor = 2;</code>
   * @return Whether the hashTableSucessor field is set.
   */
  boolean hasHashTableSucessor();
  /**
   * <code>.hashTable hashTableSucessor = 2;</code>
   * @return The hashTableSucessor.
   */
  com.ufabc.app.grpc.hashTable getHashTableSucessor();
  /**
   * <code>.hashTable hashTableSucessor = 2;</code>
   */
  com.ufabc.app.grpc.hashTableOrBuilder getHashTableSucessorOrBuilder();
}
