package com.spring.framework.core;

public class Dev {

	private Test testBean;

	public Test getTest() {
		return testBean;
	}

	public void setTest(Test test) {
		this.testBean = test;
	}

	private int age;

	Dev() {

		System.out.println("Dev constructor call");
	}

	Dev(int age) {

		System.out.println("Through constructor injection " + age);
	}

	Dev(Test test) {

		System.out.println("Through constructor injection of ref type ");
		this.testBean = test;
		this.testBean.compile();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void build() {

		System.out.println("First call from bean");
	}
}
