package com.lcydream.project;

import java.util.concurrent.Callable;

/**
 * CallAbleSum
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/17 17:22
 */
public class CallAbleSum implements Callable<Integer> {

	private Integer[] sum;

	public CallAbleSum(Integer[] sum){
		this.sum = sum;
	}

	@Override
	public Integer call() throws Exception {
		int result = 0;
		for(int i=0;i<sum.length;i++){
			result += sum[i];
		}
		return result;
	}
}
