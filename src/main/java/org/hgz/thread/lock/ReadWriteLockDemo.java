package org.hgz.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/5 11:54
 */
public class ReadWriteLockDemo {

  static Map<String, Object> map = new HashMap<> ();
  static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock ();
  static Lock r = readWriteLock.readLock ();
  static Lock w = readWriteLock.writeLock ();

  public static final Object get(String key) {
    r.lock ();
    try {
      return map.get (key);
    } finally {
      r.unlock ();
    }
  }

  public static Object put (String key, String value) {
    w.lock ();
    try {
      return map.put (key,  value);
    } finally {
      w.unlock ();
    }
  }

  public static void main(String[] args) {

  }

}