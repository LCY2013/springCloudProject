package com.lcydream.project.springcloudhystrixclientdemo.demomain;

import java.util.Random;
import java.util.concurrent.*;

/**
 * FutrueDemo
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/19 11:43
 */
public class FutrueDemo {

  private static final Random random = new Random();

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    Future<String> future =
        executorService.submit(
            () -> {
              int randomInt = random.nextInt(200);
              System.out.printf(
                  "[ThreadHelloWork-%s],%d , %d ms\n",
                  Thread.currentThread().getName(), System.currentTimeMillis(),randomInt);
              try {
                TimeUnit.MILLISECONDS.sleep(randomInt);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              return "hello word";
            });

    try {
      future.get(100, TimeUnit.MILLISECONDS);
    } catch (Exception e) {
      System.out.println("fault");
    }
    executorService.shutdown();
  }
}
