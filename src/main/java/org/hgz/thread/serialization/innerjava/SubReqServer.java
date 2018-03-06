package org.hgz.thread.serialization.innerjava;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 17:36
 */
public class SubReqServer {

  public static void main(String[] args) {
    SubReqServer subReqServer = new SubReqServer ();
    subReqServer.bin (8080);
  }


  public void bin(int port) {
    EventLoopGroup bossGroup = new NioEventLoopGroup ();
    EventLoopGroup workerGroup = new NioEventLoopGroup ();

    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap ();
      serverBootstrap.group (bossGroup, workerGroup)
          .channel (NioServerSocketChannel.class)
          .option (ChannelOption.SO_BACKLOG, 1024)
          .handler (new LoggingHandler(LogLevel.INFO))
          .childHandler (new ChannelInitializer<SocketChannel> () {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
              socketChannel.pipeline ().addLast (new ObjectDecoder (1024*1024,
                  ClassResolvers.weakCachingConcurrentResolver (this.getClass ().getClassLoader ())));
              socketChannel.pipeline ().addLast (new ObjectEncoder ());
              socketChannel.pipeline ().addLast (new SubReqServerHandler() );
            }
          });
      ChannelFuture future = serverBootstrap.bind (port).sync ();
      // 等待服务端监听端口关闭
      future.channel ().closeFuture ().sync ();
    } catch (Exception e) {
      e.printStackTrace ();
    } finally {
      bossGroup.shutdownGracefully ();
      workerGroup.shutdownGracefully ();
    }
  }
  static class SubReqServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      SubscribeReq subscribeReq = (SubscribeReq) msg;
      if ("hgz".equals (subscribeReq.getUserName ())) {
        System.out.println ("Server accept client subscribe req : " + subscribeReq.toString ());
        ctx.writeAndFlush (subscribeReq);
      }
    }

    private SubscribeResp resp(int subReqId) {
      SubscribeResp resp = new SubscribeResp ();
      resp.setSubReqID (subReqId);
      resp.setRespCode (0);
      resp.setDesc ("thread book order success ");
      return resp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      cause.printStackTrace ();
      ctx.close ();
    }
  }
}