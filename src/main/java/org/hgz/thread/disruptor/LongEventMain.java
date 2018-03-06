package org.hgz.thread.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/20 10:31
 */
public class LongEventMain {

  public static void main(String[] args) throws InterruptedException {
    Executor executor = Executors.newCachedThreadPool();


    // The factory for the event
    LongEventFactory factory = new LongEventFactory();

    // Specify the size of the ring buffer, must be power of 2.
    int bufferSize = 1024;

    Disruptor<LongEvent> disruptor = new Disruptor (factory, bufferSize, executor);

    // 链接处理类
    disruptor.handleEventsWith (new LongEventHandler ());


    // 启动链接类, 所有的线程将启动
    disruptor.start ();


    // 从disruptor中获取ringbuffer，ringbuffer是用作发布消息
    RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer ();


    LongEventProducer producer = new LongEventProducer (ringBuffer);

    ByteBuffer byteBuffer = ByteBuffer.allocate (8);

    for (long l = 0; true; l++) {
      byteBuffer.putLong (0, l);
      producer.onData (byteBuffer);
      Thread.sleep (1000);
    }
  }
}