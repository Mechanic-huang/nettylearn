package org.hgz.thread.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/11/30 10:13
 */
public class TwinsLock implements Lock {

  Sync sync = new Sync (2);


  private static final class Sync extends AbstractQueuedSynchronizer {
    public Sync(int count) {
      if (count <= 0) {
        throw new IllegalArgumentException ("count must large than zero");
      }
      setState (count);
    }

    @Override
    protected int tryAcquireShared(int reduceCount) {
      for(;;) {
        int current = getState ();
        int newCount = current - reduceCount;
        if (newCount < 0 || compareAndSetState (current, newCount)) {
          return newCount;
        }
      }
    }

    @Override
    protected boolean tryReleaseShared(int returnCount) {
      for (;;) {
        int current = getState();
        int newCount = current + returnCount;
        if (compareAndSetState(current, newCount)) {
          return true;
        }
      }
    }
  }



  public void lock() {
    sync.acquireShared (1);
  }

  public void lockInterruptibly() throws InterruptedException {

  }

  public boolean tryLock() {
    return false;
  }

  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return false;
  }

  public void unlock() {
    sync.releaseShared(1);
  }

  public Condition newCondition() {
    return null;
  }
}