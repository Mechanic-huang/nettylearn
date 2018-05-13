package org.hgz.thread.threadlocal;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/5/3 16:44
 */
public class Demo1 {

  public static ThreadLocal<String> threadLocal = new ThreadLocal<> ();

  public static void main(String[] args) {


    String a  = new String("java");

    String a1 = "java";

    System.out.println (a == a1);




  }

}