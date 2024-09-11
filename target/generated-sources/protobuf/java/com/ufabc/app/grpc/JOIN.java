// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/DHT.proto

// Protobuf Java Version: 3.25.1
package com.ufabc.app.grpc;

/**
 * <pre>
 *Roteadas atraves do anel
 * </pre>
 *
 * Protobuf type {@code JOIN}
 */
public final class JOIN extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:JOIN)
    JOINOrBuilder {
private static final long serialVersionUID = 0L;
  // Use JOIN.newBuilder() to construct.
  private JOIN(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private JOIN() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new JOIN();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ufabc.app.grpc.JOIN.class, com.ufabc.app.grpc.JOIN.Builder.class);
  }

  private int bitField0_;
  public static final int HASHTABLEENTRANT_FIELD_NUMBER = 1;
  private com.ufabc.app.grpc.HashTable hashTableEntrant_;
  /**
   * <code>.HashTable hashTableEntrant = 1;</code>
   * @return Whether the hashTableEntrant field is set.
   */
  @java.lang.Override
  public boolean hasHashTableEntrant() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.HashTable hashTableEntrant = 1;</code>
   * @return The hashTableEntrant.
   */
  @java.lang.Override
  public com.ufabc.app.grpc.HashTable getHashTableEntrant() {
    return hashTableEntrant_ == null ? com.ufabc.app.grpc.HashTable.getDefaultInstance() : hashTableEntrant_;
  }
  /**
   * <code>.HashTable hashTableEntrant = 1;</code>
   */
  @java.lang.Override
  public com.ufabc.app.grpc.HashTableOrBuilder getHashTableEntrantOrBuilder() {
    return hashTableEntrant_ == null ? com.ufabc.app.grpc.HashTable.getDefaultInstance() : hashTableEntrant_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getHashTableEntrant());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getHashTableEntrant());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ufabc.app.grpc.JOIN)) {
      return super.equals(obj);
    }
    com.ufabc.app.grpc.JOIN other = (com.ufabc.app.grpc.JOIN) obj;

    if (hasHashTableEntrant() != other.hasHashTableEntrant()) return false;
    if (hasHashTableEntrant()) {
      if (!getHashTableEntrant()
          .equals(other.getHashTableEntrant())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasHashTableEntrant()) {
      hash = (37 * hash) + HASHTABLEENTRANT_FIELD_NUMBER;
      hash = (53 * hash) + getHashTableEntrant().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ufabc.app.grpc.JOIN parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.ufabc.app.grpc.JOIN parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.ufabc.app.grpc.JOIN parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ufabc.app.grpc.JOIN parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ufabc.app.grpc.JOIN prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *Roteadas atraves do anel
   * </pre>
   *
   * Protobuf type {@code JOIN}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:JOIN)
      com.ufabc.app.grpc.JOINOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ufabc.app.grpc.JOIN.class, com.ufabc.app.grpc.JOIN.Builder.class);
    }

    // Construct using com.ufabc.app.grpc.JOIN.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getHashTableEntrantFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      hashTableEntrant_ = null;
      if (hashTableEntrantBuilder_ != null) {
        hashTableEntrantBuilder_.dispose();
        hashTableEntrantBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_descriptor;
    }

    @java.lang.Override
    public com.ufabc.app.grpc.JOIN getDefaultInstanceForType() {
      return com.ufabc.app.grpc.JOIN.getDefaultInstance();
    }

    @java.lang.Override
    public com.ufabc.app.grpc.JOIN build() {
      com.ufabc.app.grpc.JOIN result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ufabc.app.grpc.JOIN buildPartial() {
      com.ufabc.app.grpc.JOIN result = new com.ufabc.app.grpc.JOIN(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.ufabc.app.grpc.JOIN result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.hashTableEntrant_ = hashTableEntrantBuilder_ == null
            ? hashTableEntrant_
            : hashTableEntrantBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ufabc.app.grpc.JOIN) {
        return mergeFrom((com.ufabc.app.grpc.JOIN)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ufabc.app.grpc.JOIN other) {
      if (other == com.ufabc.app.grpc.JOIN.getDefaultInstance()) return this;
      if (other.hasHashTableEntrant()) {
        mergeHashTableEntrant(other.getHashTableEntrant());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getHashTableEntrantFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.ufabc.app.grpc.HashTable hashTableEntrant_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ufabc.app.grpc.HashTable, com.ufabc.app.grpc.HashTable.Builder, com.ufabc.app.grpc.HashTableOrBuilder> hashTableEntrantBuilder_;
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     * @return Whether the hashTableEntrant field is set.
     */
    public boolean hasHashTableEntrant() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     * @return The hashTableEntrant.
     */
    public com.ufabc.app.grpc.HashTable getHashTableEntrant() {
      if (hashTableEntrantBuilder_ == null) {
        return hashTableEntrant_ == null ? com.ufabc.app.grpc.HashTable.getDefaultInstance() : hashTableEntrant_;
      } else {
        return hashTableEntrantBuilder_.getMessage();
      }
    }
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     */
    public Builder setHashTableEntrant(com.ufabc.app.grpc.HashTable value) {
      if (hashTableEntrantBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        hashTableEntrant_ = value;
      } else {
        hashTableEntrantBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     */
    public Builder setHashTableEntrant(
        com.ufabc.app.grpc.HashTable.Builder builderForValue) {
      if (hashTableEntrantBuilder_ == null) {
        hashTableEntrant_ = builderForValue.build();
      } else {
        hashTableEntrantBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     */
    public Builder mergeHashTableEntrant(com.ufabc.app.grpc.HashTable value) {
      if (hashTableEntrantBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          hashTableEntrant_ != null &&
          hashTableEntrant_ != com.ufabc.app.grpc.HashTable.getDefaultInstance()) {
          getHashTableEntrantBuilder().mergeFrom(value);
        } else {
          hashTableEntrant_ = value;
        }
      } else {
        hashTableEntrantBuilder_.mergeFrom(value);
      }
      if (hashTableEntrant_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     */
    public Builder clearHashTableEntrant() {
      bitField0_ = (bitField0_ & ~0x00000001);
      hashTableEntrant_ = null;
      if (hashTableEntrantBuilder_ != null) {
        hashTableEntrantBuilder_.dispose();
        hashTableEntrantBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     */
    public com.ufabc.app.grpc.HashTable.Builder getHashTableEntrantBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getHashTableEntrantFieldBuilder().getBuilder();
    }
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     */
    public com.ufabc.app.grpc.HashTableOrBuilder getHashTableEntrantOrBuilder() {
      if (hashTableEntrantBuilder_ != null) {
        return hashTableEntrantBuilder_.getMessageOrBuilder();
      } else {
        return hashTableEntrant_ == null ?
            com.ufabc.app.grpc.HashTable.getDefaultInstance() : hashTableEntrant_;
      }
    }
    /**
     * <code>.HashTable hashTableEntrant = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ufabc.app.grpc.HashTable, com.ufabc.app.grpc.HashTable.Builder, com.ufabc.app.grpc.HashTableOrBuilder> 
        getHashTableEntrantFieldBuilder() {
      if (hashTableEntrantBuilder_ == null) {
        hashTableEntrantBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.ufabc.app.grpc.HashTable, com.ufabc.app.grpc.HashTable.Builder, com.ufabc.app.grpc.HashTableOrBuilder>(
                getHashTableEntrant(),
                getParentForChildren(),
                isClean());
        hashTableEntrant_ = null;
      }
      return hashTableEntrantBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:JOIN)
  }

  // @@protoc_insertion_point(class_scope:JOIN)
  private static final com.ufabc.app.grpc.JOIN DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ufabc.app.grpc.JOIN();
  }

  public static com.ufabc.app.grpc.JOIN getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<JOIN>
      PARSER = new com.google.protobuf.AbstractParser<JOIN>() {
    @java.lang.Override
    public JOIN parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<JOIN> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<JOIN> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ufabc.app.grpc.JOIN getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

