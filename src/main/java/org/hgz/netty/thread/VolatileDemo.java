package org.hgz.netty.thread;

/**
 * @author huang_guozhong
 * @Description volatile例子  可见性
 * @Copyright 2015 © anzhi.com
 * @Created 2017/11/24 14:12
 */
public class VolatileDemo {

  private static boolean flag = false;
  private volatile  static boolean volatileFlag = false;
  public static void main(String[] args) throws InterruptedException {
    Thread t1 =  new Thread (new Runnable () {
      public void run() {
        while(!flag) {
        }
        System.out.println ("一般方法执行完成");
      }
    });

    Thread t2 =  new Thread (new Runnable () {
      public void run() {
        while(!volatileFlag) {
        }
        System.out.println ("volatile 执行完成");
      }
    });
    t1.start ();
    t2.start ();

    Thread.sleep (1000);

    volatileFlag = true;
    flag = true;
  }





}