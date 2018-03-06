package org.hgz.thread.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/5 15:52
 */
public class BlockingQueueDemo {

  public static void main(String[] args) {
    /**
     * 使用可重入锁 和 Condition构成的  notEmty  notFull 等， 先进先出
     */
    ArrayBlockingQueue<String> fairQueue = new ArrayBlockingQueue<String> (100, true);

    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue (10);
    linkedBlockingQueue.poll ();

    SynchronousQueue synchronousQueue = new SynchronousQueue ();

  }
}