// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/DHT.proto

// Protobuf Java Version: 3.25.1
package com.ufabc.app.grpc;

public interface ItemOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Item)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 keyItemHash = 1;</code>
   * @return The keyItemHash.
   */
  long getKeyItemHash();

  /**
   * <code>int64 sizeValueItem = 2;</code>
   * @return The sizeValueItem.
   */
  long getSizeValueItem();

  /**
   * <code>bytes valueItem = 3;</code>
   * @return The valueItem.
   */
  com.google.protobuf.ByteString getValueItem();
}
