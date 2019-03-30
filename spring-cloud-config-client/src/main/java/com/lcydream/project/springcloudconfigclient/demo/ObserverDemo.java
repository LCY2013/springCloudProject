package com.lcydream.project.springcloudconfigclient.demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * ObserverDemo
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/2 20:06
 */
public class ObserverDemo {

  public static void main(String[] args) {
    // 新建观察者发布器
    MyObservable observable = new MyObservable();
    // 新增订阅发布
    observable.addObserver((observables, value) -> System.out.println(value));

    // 发布者通知，设置观察状态的改变
    observable.setChanged();

    // 唤醒订阅者，订阅者被动感知(推模式)
    observable.notifyObservers("Luo");

    echoIterator();
  }

	/**
	 * 拉的模式
	 */
	private static void echoIterator() {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    Iterator<Integer> iterator = integers.iterator();
    //循环主动去获取
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static class MyObservable extends Observable {
    @Override
    protected synchronized void setChanged() {
      super.setChanged();
    }
  }
}
