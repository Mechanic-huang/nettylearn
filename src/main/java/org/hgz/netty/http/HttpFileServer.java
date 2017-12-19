//package org.hgz.netty.http;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.EventLoop;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.http.HttpObjectAggregator;
//import io.netty.handler.codec.http.HttpRequestDecoder;
//import io.netty.handler.codec.http.HttpResponseEncoder;
//import io.netty.handler.stream.ChunkedWriteHandler;
//
///**
// * @author huang_guozhong
// * @Description
// * @Copyright 2015 © anzhi.com
// * @Created 2017/9/9 11:16
// */
//public class HttpFileServer {
//  private static final String DEFAULT_URL = "/src/org/hgz/netty/bio";
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