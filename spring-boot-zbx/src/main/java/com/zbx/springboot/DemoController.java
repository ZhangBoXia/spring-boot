package com.zbx.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangboxia
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/name/by-id")
	public String getName(int id){
		return port;
	}

	@GetMapping("/getTest")
	public String getTest(HttpServletRequest request) {
		String age = request.getParameter("age");
		System.out.println("age=" + age);
		new Thread(() -> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			String age1 = request.getParameter("age");
			System.out.println("age1=" + age1);
		}).start();
		return "success";
	}

	public DemoController() {
		System.out.println("====@Bean DemoController 开始调用=====");
	}
}
