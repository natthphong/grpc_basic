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
public final class FileServiceGrpc {

  private FileServiceGrpc() {}

  public static final String SERVICE_NAME = "com.prior.grpc.proto.FileService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.prior.grpc.proto.Test.FileChunk,
      com.prior.grpc.proto.Test.UploadStatus> METHOD_UPLOAD_FILES =
      io.grpc.MethodDescriptor.<com.prior.grpc.proto.Test.FileChunk, com.prior.grpc.proto.Test.UploadStatus>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.prior.grpc.proto.FileService", "UploadFiles"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.prior.grpc.proto.Test.FileChunk.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.prior.grpc.proto.Test.UploadStatus.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.prior.grpc.proto.Test.FileName,
      com.prior.grpc.proto.Test.FileChunk> METHOD_DOWNLOAD_FILES =
      io.grpc.MethodDescriptor.<com.prior.grpc.proto.Test.FileName, com.prior.grpc.proto.Test.FileChunk>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.prior.grpc.proto.FileService", "DownloadFiles"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.prior.grpc.proto.Test.FileName.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.prior.grpc.proto.Test.FileChunk.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileServiceStub newStub(io.grpc.Channel channel) {
    return new FileServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FileServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FileServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FileServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.FileChunk> uploadFiles(
        io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.UploadStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_UPLOAD_FILES, responseObserver);
    }

    /**
     */
    public void downloadFiles(com.prior.grpc.proto.Test.FileName request,
        io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.FileChunk> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DOWNLOAD_FILES, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_UPLOAD_FILES,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.prior.grpc.proto.Test.FileChunk,
                com.prior.grpc.proto.Test.UploadStatus>(
                  this, METHODID_UPLOAD_FILES)))
          .addMethod(
            METHOD_DOWNLOAD_FILES,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.prior.grpc.proto.Test.FileName,
                com.prior.grpc.proto.Test.FileChunk>(
                  this, METHODID_DOWNLOAD_FILES)))
          .build();
    }
  }

  /**
   */
  public static final class FileServiceStub extends io.grpc.stub.AbstractStub<FileServiceStub> {
    private FileServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.FileChunk> uploadFiles(
        io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.UploadStatus> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_UPLOAD_FILES, getCallOptions()), responseObserver);
    }

    /**
     */
    public void downloadFiles(com.prior.grpc.proto.Test.FileName request,
        io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.FileChunk> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_DOWNLOAD_FILES, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FileServiceBlockingStub extends io.grpc.stub.AbstractStub<FileServiceBlockingStub> {
    private FileServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.prior.grpc.proto.Test.FileChunk> downloadFiles(
        com.prior.grpc.proto.Test.FileName request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_DOWNLOAD_FILES, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileServiceFutureStub extends io.grpc.stub.AbstractStub<FileServiceFutureStub> {
    private FileServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DOWNLOAD_FILES = 0;
  private static final int METHODID_UPLOAD_FILES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DOWNLOAD_FILES:
          serviceImpl.downloadFiles((com.prior.grpc.proto.Test.FileName) request,
              (io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.FileChunk>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_FILES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadFiles(
              (io.grpc.stub.StreamObserver<com.prior.grpc.proto.Test.UploadStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class FileServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.prior.grpc.proto.Test.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FileServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileServiceDescriptorSupplier())
              .addMethod(METHOD_UPLOAD_FILES)
              .addMethod(METHOD_DOWNLOAD_FILES)
              .build();
        }
      }
    }
    return result;
  }
}
