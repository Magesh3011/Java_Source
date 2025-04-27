package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary()
public class OLED implements Television {

	public void watchMovie() {

		System.out.println("OLED TV turned onn, playing movie...");
	}

}
