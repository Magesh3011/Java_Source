package com.db.hiber.test;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Car {
	
	@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String carModel;

	
	/*
	 * Note: while using the onetomany, the new table will be created we are
	 * creating the Car and Engine tables, but the below created for the mapping
	 * Hibernate: insert into Car_Engine (Car_Id,engine_list_Id) values (?,?)
	 * 
	 * to avoid this we need to use the mapping, like 
	 * @OneToMany(cascade = CascadeType.ALL,mappedBy="car")
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL,mappedBy="car")
	private List<Engine> engine_list=new ArrayList<Engine>();
	
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
	public List<Engine> getEngine_list() {
		return engine_list;
	}
	public void setEngine_list(List<Engine> engine_list) {
		this.engine_list = engine_list;
	}
	@Override
	public String toString() {
		return "Car [Id=" + Id + ", carModel=" + carModel + "]";
	}
	
	

}
