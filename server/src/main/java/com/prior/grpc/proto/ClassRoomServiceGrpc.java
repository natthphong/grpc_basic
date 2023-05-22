package com.prior.grpc.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: test.proto")
public final class ClassRoomServiceGrpc {

  private ClassRoomServiceGrpc() {}

  public static final String SERVICE_NAME = "com.prior.grpc.proto.ClassRoomService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.prior.grpc.proto.Test.StudentGroup,
      com.prior.grpc.proto.Test.ClassRoom> METHOD_JOIN_CLASS =
      io.grpc.MethodDescriptor.<com.prior.grpc.proto.Test.StudentGroup, com.prior.grpc.proto.Test.ClassRoom>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.prior.grpc.proto.ClassRoomService", "JoinClass"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.prior.grpc.proto.Test.StudentGroup.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.prior.grpc.proto.Test.ClassRoom.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClassRoomServiceStub newStub(io.grpc.Channel channel) {
    return new ClassRoomServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClassRoomServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClassRoomServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClassRoomServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClassRoomServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClassRoomServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.StudentGroup> joinClass(
        io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.ClassRoom> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_JOIN_CLASS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_JOIN_CLASS,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.prior.grpc.proto.Test.StudentGroup,
                com.prior.grpc.proto.Test.ClassRoom>(
                  this, METHODID_JOIN_CLASS)))
          .build();
    }
  }

  /**
   */
  public static final class ClassRoomServiceStub extends io.grpc.stub.AbstractStub<ClassRoomServiceStub> {
    private ClassRoomServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClassRoomServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClassRoomServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClassRoomServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.StudentGroup> joinClass(
        io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.ClassRoom> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_JOIN_CLASS, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ClassRoomServiceBlockingStub extends io.grpc.stub.AbstractStub<ClassRoomServiceBlockingStub> {
    private ClassRoomServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClassRoomServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClassRoomServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClassRoomServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ClassRoomServiceFutureStub extends io.grpc.stub.AbstractStub<ClassRoomServiceFutureStub> {
    private ClassRoomServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClassRoomServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClassRoomServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClassRoomServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_JOIN_CLASS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClassRoomServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClassRoomServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_JOIN_CLASS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.joinClass(
              (io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.ClassRoom>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ClassRoomServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.prior.grpc.proto.Test.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ClassRoomServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClassRoomServiceDescriptorSupplier())
              .addMethod(METHOD_JOIN_CLASS)
              .build();
        }
      }
    }
    return result;
  }
}
