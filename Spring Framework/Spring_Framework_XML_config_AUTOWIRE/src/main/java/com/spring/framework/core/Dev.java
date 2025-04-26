package com.spring.framework.core;

public class Dev implements Engineer {

	private Engineer engineer;

	public Engineer getEngineer() {
		return engineer;
	}

	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}

	private int age;

	Dev() {

		System.out.println("Dev constructor call");
	}

	Dev(int age) {

		System.out.println("Through constructor injection " + age);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void build() {

		System.out.println("First call from bean from dev class");
		engineer.build();
	}
}
