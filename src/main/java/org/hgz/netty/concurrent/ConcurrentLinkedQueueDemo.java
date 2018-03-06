package org.hgz.netty.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/5 14:40
 */
public class ConcurrentLinkedQueueDemo {

  // ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列, 先进先出，添加从尾部，获取从头部

  /**
   * 才用 wait-free 即CAS算法
   * @param args
   */
  public static void main(String[] args) {
    ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue ();

    queue.add ("a");


    queue.poll ();



  }

}