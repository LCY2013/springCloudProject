package com.lcydream.project;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * SumThreadLocal
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/17 16:49
 */
public class SumThreadLocal<T> extends ThreadLocal<T> {

	private final static  ConcurrentMap<Thread,ThreadLocal> concurrentMap =
			new ConcurrentHashMap<>();

	@Override
	public void set(T value) {
		super.set(value);
		concurrentMap.put(Thread.currentThread(),this);
	}

	public T getValue(Thread thread) {
		if(concurrentMap != null && concurrentMap.size() > 0){
			return (T)concurrentMap.get(thread).get();
		}
		return super.get();
	}
}
