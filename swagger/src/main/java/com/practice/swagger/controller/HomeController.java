package com.practice.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.swagger.model.Car;
import com.practice.swagger.service.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Car API", description = "Operations related to cars")
@RestController
public class HomeController {

	@Autowired
	private CarService carService;

	@Operation(summary = "Get home page", description = "Returns a string with welcome invite")

	@GetMapping("/homepage")
	public String homepage() {

		return "Welcome to home page. Thank you";
	}

	@GetMapping("/getall")
	public List<Car> getAllDetials() {

		return carService.getAllCarInfo();
	}

	@PostMapping("/getbycar/{id}")
	@ApiResponse(responseCode = "201", description = "found the car object")
	public Car getCarById(
			@Parameter(description = "Get the Car by passing the id through URL", required = true) @PathVariable int id) {

		return carService.getCarById(id);
	}

}
