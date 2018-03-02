package org.hgz.netty.disruptor;

import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/20 10:38
 */
public class LongEventProducer {
  private final RingBuffer<LongEvent> ringBuffer;

  public LongEventProducer(
      RingBuffer<LongEvent> ringbuffer) {
    this.ringBuffer = ringbuffer;
  }

  public void onData(ByteBuffer byteBuffer) {
    // 是一个计数器
    long sequence = ringBuffer.next(); // 获取下一个序列
    try {
      LongEvent longEvent = ringBuffer.get (sequence);
      longEvent.setValue (byteBuffer.getLong (0));  // 放入数据
    }
    finally {
      ringBuffer.publish (sequence);
    }

  }
}