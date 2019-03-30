package com.lcydream.project;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * FutureTest
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/17 17:19
 */
public class FutureTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Integer[] array = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] array1 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 19};
    Integer[] array2 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 18, 20};

    // 创建线程池
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // 提交任务
    Future<Integer> future = executorService.submit(new CallAbleSum(array));
    Future<Integer> future1 = executorService.submit(new CallAbleSum(array1));
    Future<Integer> future2 = executorService.submit(new CallAbleSum(array2));

    System.out.println(future.get()+future1.get()+future2.get());

    executorService.shutdown();
  }
}
