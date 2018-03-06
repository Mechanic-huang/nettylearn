package org.hgz.thread.marsh;

import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/13 17:57
 */
public class MarshallingCodeCFactory {


  /**
   * 创建 JBoss Marshalling 解码器
   * @return
   */
  public static MarshallingDecoder buidMarshallingDecoder() {
    final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory ("serial");
    final MarshallingConfiguration configuration = new MarshallingConfiguration ();
    configuration.setVersion (5);
    UnmarshallerProvider provider = new DefaultUnmarshallerProvider (
        marshallerFactory, configuration);
    MarshallingDecoder decoder = new MarshallingDecoder (provider);
    return decoder;
  }

  /**
   * 创建 JBoss marshalling 编码器
   * @return
   */
  public static MarshallingEncoder buildMarshallingEncoder() {
    final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory ("serial");
    final MarshallingConfiguration configuration = new MarshallingConfiguration ();
    configuration.setVersion (5);
    MarshallerProvider provider = new DefaultMarshallerProvider (
        marshallerFactory, configuration);
    MarshallingEncoder encoder = new MarshallingEncoder (provider);
    return encoder;
  }

}