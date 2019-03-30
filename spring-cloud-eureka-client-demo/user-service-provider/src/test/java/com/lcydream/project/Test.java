package com.lcydream.project;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Test
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/17 16:11
 */
public class Test {

	private static SumThreadLocal<Integer> sumInteger = new SumThreadLocal<>();

    public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9};
		Integer[] array1 = new Integer[]{1,2,3,4,5,6,7,8,9};
		Integer[] array2 = new Integer[]{1,2,3,4,5,6,7,8,9};

    Thread thread =
        new Thread(
            () -> {
              Integer sum = 0;
              for (int i = 0; i < array.length; i++) {
                sum += array[i];
              }
              sumInteger.set(sum);
              System.out.println(sumInteger.get());
            });
	    thread.start();

	    Thread thread1 = new Thread(()->{
			Integer sum = 0;
			for (int i=0 ; i<array1.length ; i++){
				sum += array1[i];
			}
			sumInteger.set(sum);
		    System.out.println(sumInteger.get());
		});
	    thread1.start();

	    Thread thread2 = new Thread(()->{
			Integer sum = 0;
			for (int i=0 ; i<array2.length ; i++){
				sum += array2[i];
			}
			sumInteger.set(sum);
		    System.out.println(sumInteger.get());
		});
	    thread2.start();
	    try {
	    	thread.join();
	    	thread1.join();
		    thread2.join();
	    } catch (InterruptedException e) {
		    e.printStackTrace();
	    }

	    System.out.println(sumInteger.getValue(thread));

	    RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }
}
