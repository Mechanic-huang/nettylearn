package org.hgz.thread.serialization.innerjava;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 17:58
 */
public class SubReqClient {

  public static void main(String[] args) {
    SubReqClient subReqClient = new SubReqClient ();
    subReqClient.connet (8080, "localhost");
  }


  public void connet(int port, String host) {
    EventLoopGroup group = new NioEventLoopGroup ();
    try {
      Bootstrap bootstrap = new Bootstrap ();
      bootstrap.group (group)
          .channel (NioSocketChannel.class)
          .option (ChannelOption.TCP_NODELAY, true)
          .handler (new ChannelInitializer<SocketChannel> () {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
              socketChannel.pipeline ().addLast (new ObjectDecoder (1024,
                  ClassResolvers.cacheDisabled (this.getClass ().getClassLoader ())));
              socketChannel.pipeline ().addLast (new ObjectEncoder ());
              socketChannel.pipeline ().addLast (new SubReqClientHandler ());

            }
          });

      ChannelFuture future = bootstrap.connect (host, port).sync ();
      future.channel ().closeFuture ().sync ();
    } catch (Exception e) {
      e.printStackTrace ();
    }
  }

  static class SubReqClientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
      for (int i = 0; i < 10; i++) {
        ctx.write (subReq (i));
      }
      ctx.flush ();
    }


    private SubscribeReq subReq(int i) {
      SubscribeReq subscribeReq = new SubscribeReq ();
      subscribeReq.setAddress ("黑龙江哈尔滨");
      subscribeReq.setPhoneNumber ("138000000000");
      subscribeReq.setProductName ("thread learn");
      subscribeReq.setSubReqID (i);
      subscribeReq.setUserName ("hgz");
      return subscribeReq;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      System.out.println ("receive server response is : " + msg.toString ());
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
      ctx.flush ();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      cause.printStackTrace ();
      ctx.close ();
    }
  }
}