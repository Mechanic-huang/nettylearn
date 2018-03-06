package org.hgz.thread.demo;


import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/15 16:13
 */
public class DirectDemo {

  public static void main(String[] args) throws InterruptedException {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect (1024 * 1024 * 128);

    TimeUnit.SECONDS.sleep (2);

    System.out.println ("OK");
  }
}