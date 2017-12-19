package org.hgz.netty.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/11/29 10:38
 */
public class SimpleLock implements Lock {


  private final Syns syns = new Syns ();

  public void lock() {
    syns.acquire (1);
  }

  public void lockInterruptibly() throws InterruptedException {

  }

  public boolean tryLock() {
    return syns.tryAcquire (1);
  }

  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return false;
  }

  public void unlock() {
    syns.release(1);
  }

  /**
   * 等待通知组件，该组件与当前锁绑定。
   * 只有当前的线程获取了锁才能调用 condition的wait方法，而调用后当前线程释放锁
   * @return
   */
  public Condition newCondition() {
//    return syns.newCondition();
    return null;
  }









  /**
   * 同步器实现类
   */
  static class Syns extends AbstractQueuedSynchronizer {

    public Syns() {
    }

    @Override
    protected boolean tryAcquire(int arg) {
      if (compareAndSetState (0, 1)) {
        setExclusiveOwnerThread (Thread.currentThread ());
        return true;
      }
      return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
      if (getState () == 0) {
        throw new IllegalMonitorStateException ();
      }
//      setExclusiveOwnerThread (null);
      setState (0);
      return true;
    }

    @Override
    protected int tryAcquireShared(int arg) {
      return super.tryAcquireShared (arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
      return super.tryReleaseShared (arg);
    }

    @Override
    protected boolean isHeldExclusively() {
      return getState () == 1;
    }

    @Override
    public String toString() {
      return super.toString ();
    }


  }
}