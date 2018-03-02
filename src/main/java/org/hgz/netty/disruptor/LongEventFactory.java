package org.hgz.netty.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/20 10:32
 */
public class LongEventFactory implements EventFactory<LongEvent> {

  public LongEvent newInstance() {
    return new LongEvent ();
  }
}