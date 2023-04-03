package com.zbx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootZbxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZbxApplication.class, args);
	}

	@Bean
	public User user(){
		System.out.println("====@Bean user 开始调用=====");
		return new User();
	}
}
