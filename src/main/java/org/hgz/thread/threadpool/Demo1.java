package org.hgz.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/5 17:04
 */
public class Demo1 {


  public static void main(String[] args) {
    ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<> (100);
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor (10, 20, 100L, TimeUnit.SECONDS,
        runnables);
    threadPoolExecutor.prestartAllCoreThreads ();
    threadPoolExecutor.execute (new Runnable () {
      @Override
      public void run() {
        System.out.println ("hello, world");
      }
    });
    threadPoolExecutor.shutdownNow ();

    //  LinkedBlockingQueue corepoolsize == maxPoolsize 说明： 限制当前获取资源的线程数；适用于负载比较重的服务器
    Executors.newFixedThreadPool (10);

    // SynchronousQueue 不存储任务 ， maxpoolsize = Integer.MaxValue corepoolsize 默认大小是 0 说明：任务的小程序，或是负载较轻的服务器。
    Executors.newCachedThreadPool ();

    // LinkedBlockingQueue corePoolSize == maxPoolSize =1  说明： 适用于需要顺序执行的任务，并且在任意时间点不会有多个活动线程是执行的
    Executors.newSingleThreadExecutor ();

    
    Executors.newScheduledThreadPool (1);  // 周期任务 适用于需要多个后台线程执行周期任务，同时为了满足资源管理的需求而需要限制后台线程的数量的应用场景

    ScheduledExecutorService scheduledExecutorService = Executors
        .newSingleThreadScheduledExecutor ();



  }

}