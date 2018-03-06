//package org.hgz.netty.http;
//
//import io.thread.bootstrap.ServerBootstrap;
//import io.thread.channel.ChannelFuture;
//import io.thread.channel.ChannelInitializer;
//import io.thread.channel.ChannelPipeline;
//import io.thread.channel.EventLoop;
//import io.thread.channel.EventLoopGroup;
//import io.thread.channel.nio.NioEventLoopGroup;
//import io.thread.channel.socket.SocketChannel;
//import io.thread.channel.socket.nio.NioServerSocketChannel;
//import io.thread.handler.codec.http.HttpObjectAggregator;
//import io.thread.handler.codec.http.HttpRequestDecoder;
//import io.thread.handler.codec.http.HttpResponseEncoder;
//import io.thread.handler.stream.ChunkedWriteHandler;
//
///**
// * @author huang_guozhong
// * @Description
// * @Copyright 2015 © anzhi.com
// * @Created 2017/9/9 11:16
// */
//public class HttpFileServer {
//  private static final String DEFAULT_URL = "/src/org/hgz/thread/bio";
//
//  public void run(final int port, final String url) {
//    EventLoopGroup bossGroup = new NioEventLoopGroup ();
//    EventLoopGroup workerGroup = new NioEventLoopGroup ();
//
//    try {
//      ServerBootstrap b = new ServerBootstrap ();
//      b.group (bossGroup,workerGroup)
//          .channel (NioServerSocketChannel.class)
//          .childHandler (new ChannelInitializer<SocketChannel> () {
//            protected void initChannel(SocketChannel socketChannel) throws Exception {
//              ChannelPipeline pipeline = socketChannel.pipeline ();
//              pipeline.addLast ("http-decoder", new HttpRequestDecoder ());
//              pipeline.addLast ("http-aggregator", new HttpObjectAggregator (65536));
//              pipeline.addLast ("http-encoder", new HttpResponseEncoder ());
//              pipeline.addLast ("http-chunked", new ChunkedWriteHandler ());
//              pipeline.addLast ("fileServerHandler", new );
//
//
//            }
//          });
//      ChannelFuture future = b.bind (port).sync ();
//      future.channel ().closeFuture ().sync ();
//    } catch (Exception e) {
//      e.printStackTrace ();
//    } finally {
//      bossGroup.shutdownGracefully ();
//      workerGroup.shutdownGracefully ();
//    }
//  }
//
//
//
//}