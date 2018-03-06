package org.hgz.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huang_guozhong
 * @Description 可重入锁
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/2 14:00
 */
public class ReentrantLockDemo {

  public static void main(String[] args) {
    // 可以指定是否公平
    ReentrantLock reentrantLock = new ReentrantLock (true);
    reentrantLock.lock ();
    reentrantLock.unlock ();

    try {
      reentrantLock.lockInterruptibly();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }
}