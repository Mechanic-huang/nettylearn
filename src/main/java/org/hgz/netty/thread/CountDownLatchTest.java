package org.hgz.netty.thread;

import java.util.concurrent.CountDownLatch;
import sun.java2d.SurfaceDataProxy.CountdownTracker;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/11/30 13:48
 */
public class CountDownLatchTest {

  static CountDownLatch c = new CountDownLatch (2);


  public static void main(String[] args) throws InterruptedException {
    new Thread (new Runnable () {
      public void run() {
        System.out.println (1);
        c.countDown ();
        System.out.println (2);
        c.countDown ();
      }
    }).start ();
    // 阻塞到
    c.await ();
    System.out.println (3);
  }

}