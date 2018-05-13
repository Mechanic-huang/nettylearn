package org.hgz.exception;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/5/3 15:43
 */
public class TryCacheFinallyDemo {

  public static void main(String[] args) {

    System.out.println (getResult ());





  }

  public static int getResult(){
    int reult = 0;

    try {
      int a = 1/0;
    } catch (Exception e) {
      return reult;
    } finally {
      reult = 10;
    }

    return 2;
  }

}