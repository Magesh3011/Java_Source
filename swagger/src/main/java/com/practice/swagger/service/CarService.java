package com.practice.swagger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.swagger.model.Car;

@Service
public class CarService {
	private List<Car> carList = new ArrayList<>(Arrays.asList(new Car(100, "AUDI"), new Car(101, "BMW")));

	public List<Car> getAllCarInfo() {

		return carList;
	}

	public Car getCarById(int id) {
		// TODO Auto-generated method stub
		return carList.stream().filter(f -> f.getModelNumber() == id).findFirst().orElse(null);
	}

}
