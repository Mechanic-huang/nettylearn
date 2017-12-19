package org.hgz.netty.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huang_guozhong
 * @Description SingleThreadExecutor
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/26 14:39
 */
public class ExecutorDemo1 {

  public static void main(String[] args) {
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor ();
    singleThreadExecutor.execute (new LiftOff ());
    singleThreadExecutor.shutdown ();
  }

  static class LiftOff implements Runnable {

    protected  int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount ++;


    public LiftOff(){

    }
    public LiftOff(int countDown){
      this.countDown=countDown;
    }

    public String status(){
      return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"),";
    }
    public void run() {
      while(countDown-->0){
        System.out.print(status());
        Thread.yield();
      }
    }
  }


}