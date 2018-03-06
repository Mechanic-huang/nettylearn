package org.hgz.thread.timer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.net.SocketAddress;
import java.util.Date;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 14:27
 */
public class TimeServerHandler extends ChannelHandlerAdapter {    // 对网络事件进行读写操作

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf buf = (ByteBuf) msg;
    byte[] req = new byte[buf.readableBytes ()];      // 获得缓冲区的可读字节数
    buf.readBytes (req);
    String body = new String (req, "UTF-8");
    System.out.println ("The time server receive order : " + body);
    String currentTime =
        "QUERY TIME ORDER".equalsIgnoreCase (body) ? new Date ().toString () : "BAD ORDER";
    ByteBuf resp = Unpooled.copiedBuffer (currentTime.getBytes ());
    ctx.write (resp);
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    ctx.flush ();   // 将消息队列的数据发送到端
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.close ();     // 关闭 ，释放与其相关的句柄类
  }

  @Override
  public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress,
      SocketAddress localAddress, ChannelPromise promise) throws Exception {
    super.connect (ctx, remoteAddress, localAddress, promise);
  }
}