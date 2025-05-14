package com.db.hiber.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Engine {

	@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String enginePower;
	
	/*
	 * @OneToOne(mappedBy="engine") private Car car;
	 * 
	 * public Car getCar() { return car; } public void setCar(Car car) { this.car =
	 * car; }
	 */
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(String enginePower) {
		this.enginePower = enginePower;
	}
	@Override
	public String toString() {
		return "Engine [Id=" + Id + ", enginePower=" + enginePower + "]";
	}

	
	
}
