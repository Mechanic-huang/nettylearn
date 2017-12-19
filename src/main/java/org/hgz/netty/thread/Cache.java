package org.hgz.netty.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/11/30 10:45
 */
public class Cache {

  static Map<String, Object> map = new HashMap<String, Object> ();
  static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock ();

  static Lock  r = readWriteLock.readLock();
  static Lock w = readWriteLock.writeLock();



  public static final Object get(String key) {
    r.lock ();
    try {
      return map.get (key);
    } finally {
      r.unlock ();
    }
  }

  public static final Object put(String key, Object value) {
    w.lock ();
    try {
      return map.put (key, value);
    } finally {
      w.unlock ();
    }
  }


  public static final void cleanAll() {
    w.lock ();
    try {
      map.clear ();
    } finally {
      w.unlock ();
    }
  }


  public static void main(String[] args) throws InterruptedException {
    Cache.put ("hgz", "黄国仲");
    Cache.get ("hgz");

    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap ();

    ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue ();

    concurrentLinkedQueue.add ("a");
    Long a = new Long (123);
    int i = a.intValue ();

//    Thread a = new Thread ();
//    a.start ();
//    a.join ();
  }

}