package org.hgz.thread.timer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 14:22
 */
public class TimerServer {

  public static void main(String[] args) {
    int port = 8080;
    TimerServer timerServer = new TimerServer ();
    timerServer.bind (port);
  }

  public void bind(int port) {

    // 组线程，包含一组nio线程，专门对网络事件进行处理，实际就是reactor线程组， 一个是用来网络连接，一个是用来读写
    EventLoopGroup bossGroup = new NioEventLoopGroup (1);
    EventLoopGroup workerGroup = new NioEventLoopGroup (1);

    try{
      ServerBootstrap serverBootstrap = new ServerBootstrap ();   // 辅助启动类，降低服务端开发复杂度
      serverBootstrap.group (bossGroup, workerGroup)
          .channel (NioServerSocketChannel.class)     // 设置创建的channel为NioServerSocketChannel
          .option (ChannelOption.SO_BACKLOG, 1024)    // 配置tcp参数
          .childHandler (new ChildChannelHandler ());     // 绑定IO事件的处理类 ，例如记录日志，对消息的处理等

      ChannelFuture future = serverBootstrap.bind (port).sync ();   // 绑定监听端口， 等待绑定完成
      System.out.println ("bind ready");
      future.channel ().closeFuture ().sync (); // 等待服务端关闭链路 方法推出

    } catch (Exception e) {
      e.printStackTrace ();
    } finally {
      bossGroup.shutdownGracefully ();
      workerGroup.shutdownGracefully ();
    }
  }

  private static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {
      socketChannel.pipeline ().addLast (new TimeServerHandler ());
    }
  }



}