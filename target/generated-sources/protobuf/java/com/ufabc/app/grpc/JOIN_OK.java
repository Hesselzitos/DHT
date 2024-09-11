// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/DHT.proto

// Protobuf Java Version: 3.25.1
package com.ufabc.app.grpc;

/**
 * <pre>
 *Enviadas diretamente para os ao destinatario
 * </pre>
 *
 * Protobuf type {@code JOIN_OK}
 */
public final class JOIN_OK extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:JOIN_OK)
    JOIN_OKOrBuilder {
private static final long serialVersionUID = 0L;
  // Use JOIN_OK.newBuilder() to construct.
  private JOIN_OK(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private JOIN_OK() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new JOIN_OK();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_OK_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_OK_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ufabc.app.grpc.JOIN_OK.class, com.ufabc.app.grpc.JOIN_OK.Builder.class);
  }

  private int bitField0_;
  public static final int HASHTABLEPREDECESSOR_FIELD_NUMBER = 1;
  private com.ufabc.app.grpc.hashTable hashTablePredecessor_;
  /**
   * <code>.hashTable hashTablePredecessor = 1;</code>
   * @return Whether the hashTablePredecessor field is set.
   */
  @java.lang.Override
  public boolean hasHashTablePredecessor() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.hashTable hashTablePredecessor = 1;</code>
   * @return The hashTablePredecessor.
   */
  @java.lang.Override
  public com.ufabc.app.grpc.hashTable getHashTablePredecessor() {
    return hashTablePredecessor_ == null ? com.ufabc.app.grpc.hashTable.getDefaultInstance() : hashTablePredecessor_;
  }
  /**
   * <code>.hashTable hashTablePredecessor = 1;</code>
   */
  @java.lang.Override
  public com.ufabc.app.grpc.hashTableOrBuilder getHashTablePredecessorOrBuilder() {
    return hashTablePredecessor_ == null ? com.ufabc.app.grpc.hashTable.getDefaultInstance() : hashTablePredecessor_;
  }

  public static final int HASHTABLESUCESSOR_FIELD_NUMBER = 2;
  private com.ufabc.app.grpc.hashTable hashTableSucessor_;
  /**
   * <code>.hashTable hashTableSucessor = 2;</code>
   * @return Whether the hashTableSucessor field is set.
   */
  @java.lang.Override
  public boolean hasHashTableSucessor() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>.hashTable hashTableSucessor = 2;</code>
   * @return The hashTableSucessor.
   */
  @java.lang.Override
  public com.ufabc.app.grpc.hashTable getHashTableSucessor() {
    return hashTableSucessor_ == null ? com.ufabc.app.grpc.hashTable.getDefaultInstance() : hashTableSucessor_;
  }
  /**
   * <code>.hashTable hashTableSucessor = 2;</code>
   */
  @java.lang.Override
  public com.ufabc.app.grpc.hashTableOrBuilder getHashTableSucessorOrBuilder() {
    return hashTableSucessor_ == null ? com.ufabc.app.grpc.hashTable.getDefaultInstance() : hashTableSucessor_;
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
      output.writeMessage(1, getHashTablePredecessor());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(2, getHashTableSucessor());
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
        .computeMessageSize(1, getHashTablePredecessor());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getHashTableSucessor());
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
    if (!(obj instanceof com.ufabc.app.grpc.JOIN_OK)) {
      return super.equals(obj);
    }
    com.ufabc.app.grpc.JOIN_OK other = (com.ufabc.app.grpc.JOIN_OK) obj;

    if (hasHashTablePredecessor() != other.hasHashTablePredecessor()) return false;
    if (hasHashTablePredecessor()) {
      if (!getHashTablePredecessor()
          .equals(other.getHashTablePredecessor())) return false;
    }
    if (hasHashTableSucessor() != other.hasHashTableSucessor()) return false;
    if (hasHashTableSucessor()) {
      if (!getHashTableSucessor()
          .equals(other.getHashTableSucessor())) return false;
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
    if (hasHashTablePredecessor()) {
      hash = (37 * hash) + HASHTABLEPREDECESSOR_FIELD_NUMBER;
      hash = (53 * hash) + getHashTablePredecessor().hashCode();
    }
    if (hasHashTableSucessor()) {
      hash = (37 * hash) + HASHTABLESUCESSOR_FIELD_NUMBER;
      hash = (53 * hash) + getHashTableSucessor().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ufabc.app.grpc.JOIN_OK parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.ufabc.app.grpc.JOIN_OK parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.ufabc.app.grpc.JOIN_OK parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ufabc.app.grpc.JOIN_OK parseFrom(
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
  public static Builder newBuilder(com.ufabc.app.grpc.JOIN_OK prototype) {
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
   *Enviadas diretamente para os ao destinatario
   * </pre>
   *
   * Protobuf type {@code JOIN_OK}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:JOIN_OK)
      com.ufabc.app.grpc.JOIN_OKOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_OK_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_OK_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ufabc.app.grpc.JOIN_OK.class, com.ufabc.app.grpc.JOIN_OK.Builder.class);
    }

    // Construct using com.ufabc.app.grpc.JOIN_OK.newBuilder()
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
        getHashTablePredecessorFieldBuilder();
        getHashTableSucessorFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      hashTablePredecessor_ = null;
      if (hashTablePredecessorBuilder_ != null) {
        hashTablePredecessorBuilder_.dispose();
        hashTablePredecessorBuilder_ = null;
      }
      hashTableSucessor_ = null;
      if (hashTableSucessorBuilder_ != null) {
        hashTableSucessorBuilder_.dispose();
        hashTableSucessorBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ufabc.app.grpc.DHTProto.internal_static_JOIN_OK_descriptor;
    }

    @java.lang.Override
    public com.ufabc.app.grpc.JOIN_OK getDefaultInstanceForType() {
      return com.ufabc.app.grpc.JOIN_OK.getDefaultInstance();
    }

    @java.lang.Override
    public com.ufabc.app.grpc.JOIN_OK build() {
      com.ufabc.app.grpc.JOIN_OK result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ufabc.app.grpc.JOIN_OK buildPartial() {
      com.ufabc.app.grpc.JOIN_OK result = new com.ufabc.app.grpc.JOIN_OK(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.ufabc.app.grpc.JOIN_OK result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.hashTablePredecessor_ = hashTablePredecessorBuilder_ == null
            ? hashTablePredecessor_
            : hashTablePredecessorBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.hashTableSucessor_ = hashTableSucessorBuilder_ == null
            ? hashTableSucessor_
            : hashTableSucessorBuilder_.build();
        to_bitField0_ |= 0x00000002;
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
      if (other instanceof com.ufabc.app.grpc.JOIN_OK) {
        return mergeFrom((com.ufabc.app.grpc.JOIN_OK)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ufabc.app.grpc.JOIN_OK other) {
      if (other == com.ufabc.app.grpc.JOIN_OK.getDefaultInstance()) return this;
      if (other.hasHashTablePredecessor()) {
        mergeHashTablePredecessor(other.getHashTablePredecessor());
      }
      if (other.hasHashTableSucessor()) {
        mergeHashTableSucessor(other.getHashTableSucessor());
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
                  getHashTablePredecessorFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getHashTableSucessorFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private com.ufabc.app.grpc.hashTable hashTablePredecessor_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ufabc.app.grpc.hashTable, com.ufabc.app.grpc.hashTable.Builder, com.ufabc.app.grpc.hashTableOrBuilder> hashTablePredecessorBuilder_;
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     * @return Whether the hashTablePredecessor field is set.
     */
    public boolean hasHashTablePredecessor() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     * @return The hashTablePredecessor.
     */
    public com.ufabc.app.grpc.hashTable getHashTablePredecessor() {
      if (hashTablePredecessorBuilder_ == null) {
        return hashTablePredecessor_ == null ? com.ufabc.app.grpc.hashTable.getDefaultInstance() : hashTablePredecessor_;
      } else {
        return hashTablePredecessorBuilder_.getMessage();
      }
    }
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     */
    public Builder setHashTablePredecessor(com.ufabc.app.grpc.hashTable value) {
      if (hashTablePredecessorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        hashTablePredecessor_ = value;
      } else {
        hashTablePredecessorBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     */
    public Builder setHashTablePredecessor(
        com.ufabc.app.grpc.hashTable.Builder builderForValue) {
      if (hashTablePredecessorBuilder_ == null) {
        hashTablePredecessor_ = builderForValue.build();
      } else {
        hashTablePredecessorBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     */
    public Builder mergeHashTablePredecessor(com.ufabc.app.grpc.hashTable value) {
      if (hashTablePredecessorBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          hashTablePredecessor_ != null &&
          hashTablePredecessor_ != com.ufabc.app.grpc.hashTable.getDefaultInstance()) {
          getHashTablePredecessorBuilder().mergeFrom(value);
        } else {
          hashTablePredecessor_ = value;
        }
      } else {
        hashTablePredecessorBuilder_.mergeFrom(value);
      }
      if (hashTablePredecessor_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     */
    public Builder clearHashTablePredecessor() {
      bitField0_ = (bitField0_ & ~0x00000001);
      hashTablePredecessor_ = null;
      if (hashTablePredecessorBuilder_ != null) {
        hashTablePredecessorBuilder_.dispose();
        hashTablePredecessorBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     */
    public com.ufabc.app.grpc.hashTable.Builder getHashTablePredecessorBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getHashTablePredecessorFieldBuilder().getBuilder();
    }
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     */
    public com.ufabc.app.grpc.hashTableOrBuilder getHashTablePredecessorOrBuilder() {
      if (hashTablePredecessorBuilder_ != null) {
        return hashTablePredecessorBuilder_.getMessageOrBuilder();
      } else {
        return hashTablePredecessor_ == null ?
            com.ufabc.app.grpc.hashTable.getDefaultInstance() : hashTablePredecessor_;
      }
    }
    /**
     * <code>.hashTable hashTablePredecessor = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ufabc.app.grpc.hashTable, com.ufabc.app.grpc.hashTable.Builder, com.ufabc.app.grpc.hashTableOrBuilder> 
        getHashTablePredecessorFieldBuilder() {
      if (hashTablePredecessorBuilder_ == null) {
        hashTablePredecessorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.ufabc.app.grpc.hashTable, com.ufabc.app.grpc.hashTable.Builder, com.ufabc.app.grpc.hashTableOrBuilder>(
                getHashTablePredecessor(),
                getParentForChildren(),
                isClean());
        hashTablePredecessor_ = null;
      }
      return hashTablePredecessorBuilder_;
    }

    private com.ufabc.app.grpc.hashTable hashTableSucessor_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ufabc.app.grpc.hashTable, com.ufabc.app.grpc.hashTable.Builder, com.ufabc.app.grpc.hashTableOrBuilder> hashTableSucessorBuilder_;
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     * @return Whether the hashTableSucessor field is set.
     */
    public boolean hasHashTableSucessor() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     * @return The hashTableSucessor.
     */
    public com.ufabc.app.grpc.hashTable getHashTableSucessor() {
      if (hashTableSucessorBuilder_ == null) {
        return hashTableSucessor_ == null ? com.ufabc.app.grpc.hashTable.getDefaultInstance() : hashTableSucessor_;
      } else {
        return hashTableSucessorBuilder_.getMessage();
      }
    }
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     */
    public Builder setHashTableSucessor(com.ufabc.app.grpc.hashTable value) {
      if (hashTableSucessorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        hashTableSucessor_ = value;
      } else {
        hashTableSucessorBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     */
    public Builder setHashTableSucessor(
        com.ufabc.app.grpc.hashTable.Builder builderForValue) {
      if (hashTableSucessorBuilder_ == null) {
        hashTableSucessor_ = builderForValue.build();
      } else {
        hashTableSucessorBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     */
    public Builder mergeHashTableSucessor(com.ufabc.app.grpc.hashTable value) {
      if (hashTableSucessorBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          hashTableSucessor_ != null &&
          hashTableSucessor_ != com.ufabc.app.grpc.hashTable.getDefaultInstance()) {
          getHashTableSucessorBuilder().mergeFrom(value);
        } else {
          hashTableSucessor_ = value;
        }
      } else {
        hashTableSucessorBuilder_.mergeFrom(value);
      }
      if (hashTableSucessor_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     */
    public Builder clearHashTableSucessor() {
      bitField0_ = (bitField0_ & ~0x00000002);
      hashTableSucessor_ = null;
      if (hashTableSucessorBuilder_ != null) {
        hashTableSucessorBuilder_.dispose();
        hashTableSucessorBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     */
    public com.ufabc.app.grpc.hashTable.Builder getHashTableSucessorBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getHashTableSucessorFieldBuilder().getBuilder();
    }
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     */
    public com.ufabc.app.grpc.hashTableOrBuilder getHashTableSucessorOrBuilder() {
      if (hashTableSucessorBuilder_ != null) {
        return hashTableSucessorBuilder_.getMessageOrBuilder();
      } else {
        return hashTableSucessor_ == null ?
            com.ufabc.app.grpc.hashTable.getDefaultInstance() : hashTableSucessor_;
      }
    }
    /**
     * <code>.hashTable hashTableSucessor = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ufabc.app.grpc.hashTable, com.ufabc.app.grpc.hashTable.Builder, com.ufabc.app.grpc.hashTableOrBuilder> 
        getHashTableSucessorFieldBuilder() {
      if (hashTableSucessorBuilder_ == null) {
        hashTableSucessorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.ufabc.app.grpc.hashTable, com.ufabc.app.grpc.hashTable.Builder, com.ufabc.app.grpc.hashTableOrBuilder>(
                getHashTableSucessor(),
                getParentForChildren(),
                isClean());
        hashTableSucessor_ = null;
      }
      return hashTableSucessorBuilder_;
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


    // @@protoc_insertion_point(builder_scope:JOIN_OK)
  }

  // @@protoc_insertion_point(class_scope:JOIN_OK)
  private static final com.ufabc.app.grpc.JOIN_OK DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ufabc.app.grpc.JOIN_OK();
  }

  public static com.ufabc.app.grpc.JOIN_OK getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<JOIN_OK>
      PARSER = new com.google.protobuf.AbstractParser<JOIN_OK>() {
    @java.lang.Override
    public JOIN_OK parsePartialFrom(
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

  public static com.google.protobuf.Parser<JOIN_OK> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<JOIN_OK> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ufabc.app.grpc.JOIN_OK getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
