package org.hgz.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author huang_guozhong
 * @Description 独占式的获取锁
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/5 10:56
 */
public class Mutex implements Lock {

  // 静态内部类， 定义同步组件
  private static class Sync extends AbstractQueuedSynchronizer {

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
      if (getState () == 0) throw new IllegalMonitorStateException ();
      setExclusiveOwnerThread (null);
      setState (0);
      return true;
    }

    @Override
    protected boolean isHeldExclusively() {
      return getState () == 1;
    }

    Condition newCondition() { return new ConditionObject(); }
  }

  private final Sync sync = new Sync ();
  @Override
  public void lock() {
    sync.acquire (1);
  }

  @Override
  public void lockInterruptibly() throws InterruptedException {

  }

  @Override
  public boolean tryLock() {
    return sync.tryAcquire (1);
  }

  @Override
  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return false;
  }

  @Override
  public void unlock() {
    sync.release (1);
  }

  @Override
  public Condition newCondition() {
    return null;
  }
}