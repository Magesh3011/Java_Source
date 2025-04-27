package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Home {

	// field injection
	@Autowired
	@Qualifier("led")
	private Television teli;

	void build() {

		System.out.println("Build method called by DI");
		teli.watchMovie();
	}

}
