package org.hgz.collection;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author huang_guozhong
 * @Description 測試
 * @Copyright 2015 © anzhi.com
 * @Created 2018/4/3 15:18
 */
public class Demo1 {

  public static void main(String[] args) {
    ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<> ();

    queue.add ("?");
  }

}