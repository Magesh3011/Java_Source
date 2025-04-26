package com.spring.framework.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// this source for the spring framework xml configuration,
		// other explanation in the in the spring.xml file

		System.out.println("Hello World!");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Dev obj = (Dev) context.getBean("dev");

		obj.build();

		System.out.println(obj.getAge());

	}
}
