package org.hgz.thread.demo;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/10/17 17:26
 */
public class TestDemo {


  public void test1(Object o) {
    System.out.println ("object");
  }

  public void test1(String o) {
    System.out.println ("String");
  }

  public static void main(String[] args) {

   TestDemo testDemo = new TestDemo ();
   testDemo.test1 ("abc");



  }

}