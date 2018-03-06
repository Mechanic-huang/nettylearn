package org.hgz.netty.forjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author huang_guozhong
 * @Description 、
 * @Copyright 2015 © anzhi.com
 * @Created 2018/3/5 16:09
 */
public class CountTask extends RecursiveTask<Integer> {

  // 阈值
  private static final int THRESHOLD = 2;

  private int start;
  private int end;

  public CountTask(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected Integer compute() {
    int sum = 0;
    // 如果任务足够小就计算
    boolean canCompute = (end - start) <= THRESHOLD;
    if (canCompute) {
      for(int i = start; i <= end; i++) {
        sum += i;
      }
    }else {
      // 任务大于阈值，就分裂成两个子任务进行计算

      int middle = (start + end) / 2;
      CountTask leftTask = new CountTask (start, middle);
      CountTask rightTask = new CountTask (middle + 1, end);

      // 执行子任务
      leftTask.fork ();
      rightTask.fork ();

      // 等待子任务完成，并得到其结果
      Integer leftResult = leftTask.join ();
      Integer rightResult = rightTask.join ();
      // 合并子任务

      sum = leftResult + rightResult;
    }
    return sum;
  }

  public static void main(String[] args) {
    ForkJoinPool forkJoinPool = new ForkJoinPool ();

    CountTask task = new CountTask (1,4);
    ForkJoinTask<Integer> result = forkJoinPool.submit (task);
    try{
      System.out.println (result.get ());
    } catch (Exception e) {
      e.printStackTrace ();
    }

  }
}