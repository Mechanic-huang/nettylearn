package org.hgz.netty.thread;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/11/27 18:47
 */
public class FinalDemo {

  static  class FinalReferenceEscapeExample {
    final int i;
    static FinalReferenceEscapeExample obj;

    public FinalReferenceEscapeExample () {
      i = 1;                              //1写final域
      obj = this;                          //2 this引用在此“逸出”
    }

    public static void writer() {
      new FinalReferenceEscapeExample ();
    }

    public static void reader(){
      if (obj != null) {                     //3
        int temp = obj.i;                 //4
      }
    }
  }


  public static void main(String[] args) {



  }
}