package com.db.hiber.test;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Engine {

	@Id
	private int Id;
	private String enginePower;
	
	@ManyToMany(mappedBy="engine")
	private List<Car> car=new ArrayList<Car>();
	 
	
	public List<Car> getCar() {
		return car;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}
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
