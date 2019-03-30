package com.lcydream.project.springbootcoluddemo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * SpringEventListenerDemo spring 自定义 事件/监听器
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/2 20:27
 */
public class SpringEventListenerDemo {

  public static void main(String[] args) {

    // Annotation 驱动的Spring上下文
    AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
    // 注册监听器
    annotationContext.addApplicationListener(
        (MyApplicationEvent applicationEvent) -> System.out.println("监听到信息：" + applicationEvent.getSource() + "#" + applicationEvent.getApplicationContext()));
    /*annotationContext.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
     @Override
     public void onApplicationEvent(MyApplicationEvent event) {
    	 System.out.println("监听到信息：" + event.getSource());
     }
    });*/
    // 刷新上下文配置信息
    annotationContext.refresh();

    // 发布事件
    annotationContext.publishEvent(new MyApplicationEvent(annotationContext,"spring L"));
    annotationContext.publishEvent(new MyApplicationEvent(annotationContext,"spring U"));
    annotationContext.publishEvent(new MyApplicationEvent(annotationContext,"spring O"));
    annotationContext.publishEvent(new MyApplicationEvent(annotationContext,"spring Y"));
    annotationContext.publishEvent(new MyApplicationEvent(annotationContext,"spring Y"));
    annotationContext.publishEvent(new MyApplicationEvent(annotationContext,"spring R"));
  }

  /** 自定义Spring上下文事件 */
  private static class MyApplicationEvent extends ApplicationEvent {

  	private ApplicationContext applicationContext;

    public MyApplicationEvent(ApplicationContext applicationContext, Object source) {
      super(source);
      this.applicationContext = applicationContext;
    }

	  public ApplicationContext getApplicationContext() {
		  return applicationContext;
	  }
  }
}
