package org.hgz.netty.base;

/**
 * @author huang_guozhong
 * @Description 递归学习
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/19 18:45
 */
public class RecurveDemo {
  public static void m (int i) {
    if (i == 1) {
      System.out.println ("1 * 1 = " + 1 * 1);
    }else {
      m(i -1);
      for(int j = 1; j <= i; j++) {
        System.out.print (j + " * " + i + " = " + j * i + "    ");
      }
      System.out.println ();
    }
  }


  public static void main(String[] args) {
    m (9);
  }
}