package org.hgz.thread.demo;

import java.util.PriorityQueue;

/**
 * @author huang_guozhong
 * @Description 队列学习
 * @Copyright 2015 © anzhi.com
 * @Created 2017/10/17 15:36
 */
public class QueueDemo {

  public static void main(String[] args) {
    priorityQueueDemo ();
  }

  public static void priorityQueueDemo() {
    PriorityQueue<String> priorityQueue = new PriorityQueue<String> ();
    priorityQueue.offer ("123123");

    priorityQueue.size ();
  }
}