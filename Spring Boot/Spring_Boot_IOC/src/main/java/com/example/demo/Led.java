package com.example.demo;

import org.springframework.stereotype.Component;

@Component

public class Led implements Television {

	public void watchMovie() {

		System.out.println("Led TV turned onn, playing movie...");
	}

}
