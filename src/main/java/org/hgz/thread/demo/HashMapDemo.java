package org.hgz.thread.demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/10/13 18:20
 */
public class HashMapDemo {


  public static void main(String[] args) {
    concurrentHashMapDemo ();

  }


  public static void hashMapDemo(){
    HashMap<String, Object> map = new HashMap<String, Object> ();
    int i = 0;
    for(;;) {
      map.put (++i + "", i + "");
    }

  }


  public static void concurrentHashMapDemo(){
    ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object> ();
    int i = 0;
    for(;;) {
      map.put (++i + "", i + "");
      if(i == 100) {
        break;
      }
    }

    Object o = map.get ("10");
    map.size ();
    System.out.println (o);
  }

  public static void treeMapDemo(){
    TreeMap<String, Object> map = new TreeMap<String, Object> ();

    map.put ("1", new Object ());


  }

  public static void hashTableDemo(){
    Hashtable<String, Object> hashtable = new Hashtable<String, Object> ();


    hashtable.put ("key", "value");
    hashtable.get ("key");
  }

}