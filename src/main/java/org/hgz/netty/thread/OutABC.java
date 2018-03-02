package org.hgz.netty.thread;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/2 18:25
 */
public class OutABC {


  private static Object LOCK_A = new Object();

  private static Object LOCK_B = new Object();

  private static Object LOCK_C = new Object();

  public static void main(String[] args) {

  }

  public static class PrintA implements Runnable {
    int count = 10;
    @Override
    public void run() {
      System.out.println ("A");
    }
  }

  public static class PrintB implements Runnable {
    int count = 10;
    @Override
    public void run() {
      System.out.println ("B");
    }
  }

  public static class PrintC implements Runnable {
    int count = 10;
    @Override
    public void run() {

      while (count > 0) {
        count --;
        synchronized (LOCK_B) {
          synchronized (LOCK_C) {
            System.out.println ("C");
            LOCK_C.notify ();
          }

          try {
            LOCK_B.wait ();
          } catch (InterruptedException e) {
            e.printStackTrace ();
          }
        }


      }
    }
  }



}