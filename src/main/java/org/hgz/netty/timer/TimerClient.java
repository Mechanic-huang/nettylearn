package org.hgz.netty.timer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 15:34
 */
public class TimerClient {

  public static void main(String[] args) {
    int port = 8080;
    new TimerClient ().connect (port, "localhost");
  }



  public void connect(int port, String host) {
    // 配置nio客户端线程组
    EventLoopGroup group = new NioEventLoopGroup ();
    try {
      Bootstrap b = new Bootstrap ();
      b.group (group).channel (NioSocketChannel.class)
          .option (ChannelOption.TCP_NODELAY, true)
          .handler (new TimeClientHandler ());

      ChannelFuture future = b.connect (host, port).sync ();
      future.channel ().closeFuture ().sync ();

    } catch (InterruptedException e) {
      e.printStackTrace ();
    } finally {
      group.shutdownGracefully ();
    }
  }

  private static class ChanelHandler extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {
      socketChannel.pipeline ().addLast (new TimeClientHandler ());
    }
  }

}