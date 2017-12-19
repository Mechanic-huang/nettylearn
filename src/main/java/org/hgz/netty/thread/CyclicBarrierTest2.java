package org.hgz.netty.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/11/30 13:55
 */
public class CyclicBarrierTest2 {

  static CyclicBarrier c = new CyclicBarrier (2, new A ());

  public static void main(String[] args) {
    new Thread (new Runnable () {
      public void run() {
        try {
          c.await ();
        } catch (Exception e) {

        }
        System.out.println (1);
      }
    }).start ();
    try {
      c.await ();
    } catch (InterruptedException e) {
      e.printStackTrace ();
    } catch (BrokenBarrierException e) {
      e.printStackTrace ();
    }
    System.out.println (2);
  }

  static class A implements Runnable {

    public void run() {
      System.out.println (3);
    }
  }


}