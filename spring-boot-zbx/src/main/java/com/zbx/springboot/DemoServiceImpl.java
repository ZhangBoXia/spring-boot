package com.zbx.springboot;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangboxia
 */
@Service
public class DemoServiceImpl implements DemoService{

	@Override
	public String getName(String id) {

		return null;
	}

	public static void main(String[] args) {
		Map<Class<?>, Collection<String>> observerActions = new HashMap<>();
		Class c = String.class;
		boolean b = observerActions.containsKey(c);
	}

	public DemoServiceImpl() {

			System.out.println("====@Bean DemoServiceImpl 开始调用=====");

	}
}
