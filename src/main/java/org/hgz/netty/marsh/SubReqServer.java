package org.hgz.netty.marsh;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/13 17:54
 */
public class SubReqServer {
  public void bind(int port) {
    EventLoopGroup bossGroup = new NioEventLoopGroup ();
    EventLoopGroup workerGroup = new NioEventLoopGroup ();

    try {
      ServerBootstrap b = new ServerBootstrap ();
      b.group (bossGroup, workerGroup)
          .channel (NioServerSocketChannel.class)
          .option (ChannelOption.SO_BACKLOG, 100)
          .handler (new LoggingHandler (LogLevel.INFO))
          .childHandler (new ChannelInitializer<SocketChannel> () {
            protected void initChannel(SocketChannel ch) throws Exception {
              ChannelPipeline pipeline = ch.pipeline ();
              pipeline.addLast (MarshallingCodeCFactory.buidMarshallingDecoder ());
              pipeline.addLast (MarshallingCodeCFactory.buildMarshallingEncoder ());
//              pipeline.addLast (new SubReqServerHandler());
            }
          });
    } catch (Exception e) {
      e.printStackTrace ();
    }
  }

}