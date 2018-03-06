package org.hgz.thread.timer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 15:39
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

  private final ByteBuf firstMessage;

  public TimeClientHandler() {
    byte[] req = "QUERY TIME ORDER".getBytes ();
    firstMessage = Unpooled.buffer (req.length);
    firstMessage.writeBytes (req);
  }

  // channel  与服务端建立连接以后
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    System.out.println ("TCP tcp connect");
    ChannelFuture future = ctx.writeAndFlush (firstMessage);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf buf = (ByteBuf) msg;
    byte[] req = new byte[buf.readableBytes ()];
    buf.readBytes (req);
    String body = new String (req, "UTF-8");
    System.out.println ("NOW IS : " + body);
  }


  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace ();
    ctx.close ();
  }
}