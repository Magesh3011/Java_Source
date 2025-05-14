package com.db.hiber.test;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Car {
	
	@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String carModel;

	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="car_id")	
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	@Override
	public String toString() {
		return "Car [Id=" + Id + ", carModel=" + carModel + "]";
	}
	
	

}
