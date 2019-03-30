package com.lcydream.project.springcloudhystrixclientdemo.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * HytrixDemoController
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/19 10:10
 */
@RestController
public class HystrixDemoController {

	private final static Random random = new Random();

	/**
	 * 当{@link #helloWork()} 方法调用失败或者超时，
	 *  fallback,方法{@link #errorInfo()}作为替代返回
	 *
	 * @return message
	 */
	@GetMapping("/helloWork")
	@HystrixCommand(fallbackMethod = "errorInfo",
		commandProperties = {
			@HystrixProperty(
					name = "execution.isolation.thread.timeoutInMilliseconds",
					value = "100")
		}
	)
	public String helloWork(){
		int randomInt = random.nextInt(200);

		try {
			TimeUnit.MILLISECONDS.sleep(randomInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("[ThreadHelloWork-%s],%d \n",Thread.currentThread().getName(),System.currentTimeMillis());
		return "hello work";
	}

	private String errorInfo(){
		System.out.printf("[ThreadFault-%s],%d \n",Thread.currentThread().getName(),System.currentTimeMillis());
		return "fault";
	}

	/**
	 * 当{@link #helloWork()} 方法调用失败或者超时，
	 *  fallback,方法{@link #errorInfo()}作为替代返回
	 *
	 * @return message
	 */
	@GetMapping("/helloWork1")
	public String helloWork1(){
		return new HelloWorldCommand().execute();
	}

	/**
	 * 编程的方式实现命令
	 */
	private class HelloWorldCommand extends com.netflix.hystrix.HystrixCommand<String>{

		protected HelloWorldCommand() {
			super(HystrixCommandGroupKey.Factory.asKey("HelloWorld")
					,100);
		}

		@Override
		protected String run() throws Exception {
			int randomInt = random.nextInt(200);

			try {
				TimeUnit.MILLISECONDS.sleep(randomInt);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("[ThreadCode-%s],%d \n",Thread.currentThread().getName(),System.currentTimeMillis());
			return "hello work";
		}

		/**
		 * 容错执行
		 * @return obj
		 */
		@Override
		protected String getFallback() {
			return HystrixDemoController.this.errorInfo();
		}
	}
}
