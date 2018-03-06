package org.hgz.thread.thread;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/2 18:25
 */
public class OutABC {

  /**
   *思路： 每次获得锁输出时都是， 在前一个锁上等待， 通知下个等待当前锁的线程
   * @param args
   */


  public static void main(String[] args) throws InterruptedException {
    Object LOCK_A = new Object();

    Object LOCK_B = new Object();

    Object LOCK_C = new Object();


    Thread A = new Thread(new PrintABC("A", LOCK_C, LOCK_A));
    Thread B = new Thread(new PrintABC("B", LOCK_A, LOCK_B));
    Thread C = new Thread(new PrintABC("C", LOCK_B, LOCK_C));

    A.start();
    Thread.sleep(100);
    B.start();
    Thread.sleep(100);
    C.start();

  }

  public static class PrintABC implements Runnable  {

    private String printStr;

    private Object lock_pre;

    private Object lock_now;

    public PrintABC(String printStr, Object lock_pre, Object lock_now) {
      this.printStr = printStr;
      this.lock_pre = lock_pre;
      this.lock_now = lock_now;
    }

    @Override
    public void run() {
      int count = 10;

      while (count > 0) {
        count --;

        synchronized (lock_pre) {
          synchronized (lock_now) {
            System.out.println(printStr);
            lock_now.notify();
          }

          try {
            lock_pre.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }


        }
      }

    }
  }




}