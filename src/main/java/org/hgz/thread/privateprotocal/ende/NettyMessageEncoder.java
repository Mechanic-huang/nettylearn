package org.hgz.thread.privateprotocal.ende;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import java.util.List;
import org.hgz.thread.privateprotocal.model.NettyMessage;

/**
 * @author huang_guozhong
 * @Description 消息编码器
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/9 16:47
 */
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {

  MarshallingEncoder marshallingEncoder;

  public NettyMessageEncoder() {
//    this.marshallingEncoder = Marshalling;
  }

  protected void encode(ChannelHandlerContext channelHandlerContext, NettyMessage nettyMessage,
      List<Object> list) throws Exception {
//    NioServerSocketChannel
  }
}