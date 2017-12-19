package org.hgz.netty.privateprotocal.util;

import java.io.IOException;
import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/13 17:09
 */
public class MarshallingCodecFactory {

  /**
   * 创建Jboss Marshaller
   * @return
   * @throws IOException
   */
  protected static Marshaller buildMarshalling() throws IOException {
    final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory ("serial");
    final MarshallingConfiguration configuration = new MarshallingConfiguration ();
    configuration.setVersion (5);
    Marshaller marshaller = marshallerFactory.createMarshaller (configuration);
    return marshaller;
  }


}