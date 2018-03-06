package org.hgz.netty.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/5 14:00
 */
public class ConcurrentHashMapDemo {

  public static void main(String[] args) {
    ConcurrentHashMap<String, String>  map = new ConcurrentHashMap<> ();
    String aaa = map.get ("aaa");

    map.put ("aaa", "bbb");

    map.size ();
  }
}