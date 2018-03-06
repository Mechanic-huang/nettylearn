package org.hgz.thread.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * @author huang_guozhong
 * @Description 消费者  消费消息的进度通过Sequence来控制。
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/20 10:34
 */
public class LongEventHandler implements EventHandler<LongEvent> {

  public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
    System.out.println ("Event: " + longEvent.getValue ());
  }
}