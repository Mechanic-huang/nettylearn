package org.hgz.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/5 18:25
 */
public class FutureTaskDemo1 {
  private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<> ();


  private String executionTask(final String taskName) {
    while (true) {
      Future<String> future = taskCache.get (taskName); // 1.1
      if (future == null) {
        Callable<String> task = new Callable<String> () { // 1.2
          @Override
          public String call() throws Exception {
            return taskName;
          }
        };
        FutureTask<String> futureTask = new FutureTask<String>(task);
        future = taskCache.putIfAbsent (taskName, futureTask);  //1.3

        if (future == null ) {
          future = futureTask;
          futureTask.run ();      //1.4
        }
      }

      try {
        return future.get ();     // 1.5
      } catch (Exception e) {
        taskCache.remove (taskName, future);
      }
    }



  }


}