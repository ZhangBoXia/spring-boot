package com.zbx.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringBootZbxApplicationTests {

	public int lengthOfLongestSubstring(String s){
		{
			if(s == null ) return 0;
			if(s.length() <= 1) {
				return s.length();
			}
			int max = 0;
			int l =0;
			Map<Character, Integer> map = new HashMap<>();
			for(int i=0; i<s.length(); i++){
				Integer j = map.get(s.charAt(i));
				map.put(s.charAt(i), i);
				if(j == null){
					max = Math.max(max, i-l + 1);
				}else{
					if(j >= l){

						l = j+1;
					}else{
						max = Math.max(max, i-l + 1);
					}

				}
			}
			return max;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3);
		for(int i=0; i<4; i++){
			scheduledThreadPoolExecutor.schedule(() -> process(1, scheduledThreadPoolExecutor), 0, TimeUnit.MILLISECONDS);


		}
		Thread.sleep(100);
		System.out.println(scheduledThreadPoolExecutor.getActiveCount());
	}

	public static void process(int i, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor){
		System.out.println(Thread.currentThread().getName() + "   开始执行 " + i);
		System.out.println(scheduledThreadPoolExecutor.getPoolSize());
		System.out.println(scheduledThreadPoolExecutor.getActiveCount());

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scheduledThreadPoolExecutor.schedule(() -> process(1, scheduledThreadPoolExecutor), 10000,
				TimeUnit.MILLISECONDS);
	}

	static class Task implements Runnable{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "   开始执行");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
