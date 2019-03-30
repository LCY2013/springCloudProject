package com.lcydream.project.springcloudhystrixclientdemo.demomain;

import rx.Observer;
import rx.Single;
import rx.schedulers.Schedulers;

import java.math.BigDecimal;
import java.util.Random;

/**
 * RxJavaDemo
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/19 11:53
 */
public class RxJavaDemo {

  private static final Random random = new Random();

  public static void main(String[] args) {

    double f = 0.1F;
    double sum = 0;
    BigDecimal bigDecimal = new BigDecimal("0.0");
    BigDecimal bigDecima2 = new BigDecimal("0.1");
    for (int i = 0; i < 4000000; i++) {
	    bigDecimal = bigDecimal.add(bigDecima2);
    }
    System.out.println(bigDecimal.doubleValue());
    System.out.println(sum);
    double val = 10.0019F;
    double val1 = 10.006F;
    System.out.println(val + val1);
    System.out.println(val - val1);
    System.out.println(val * val1);
    System.out.println(val / val1);

    Single.just("Rx Hello")
        // .subscribeOn(Schedulers.io())
        // immediate - 订阅当前线程池
        .subscribeOn(Schedulers.immediate())
        .subscribe(
            new Observer<String>() {
              @Override
              public void onCompleted() {
                System.out.println("完成");
              }

              @Override
              public void onError(Throwable e) {
                System.out.println("熔断保护");
              }

              @Override
              public void onNext(String s) {
                int randomInt = random.nextInt(100);
                System.out.printf(
                    "[ThreadHelloWork-%s],%d , %d ms\n",
                    Thread.currentThread().getName(), System.currentTimeMillis(), randomInt);
                if (randomInt > 50) {
                  throw new RuntimeException(s);
                }
              }
            });
    /*try {
     TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
     e.printStackTrace();
    }*/
  }
}
