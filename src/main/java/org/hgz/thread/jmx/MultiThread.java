package org.hgz.thread.jmx;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/2 15:21
 */
public class MultiThread {
/*
[6]Monitor Ctrl-Break
[5]Attach Listener
[4]Signal Dispatcher
[3]Finalizer
[2]Reference Handler
[1]main
*/

  public static void main(String[] args) {
    // 获取java线程管理MXBean
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean ();

    ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads (false, false);
    for (ThreadInfo threadInfo : threadInfos) {
      System.out.println ("[" + threadInfo.getThreadId () + "]" + threadInfo.getThreadName ());
    }

  }

}