package com.spring.framework.core;

public class Test implements Engineer {
	Test() {

		System.out.println("Test constructor call");
	}

	public void build() {

		System.out.println("Build method call for the test class");
	}

	void compile() {

		System.out.println("Complie method call for the test class");
	}
}
