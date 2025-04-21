package com.db.hiber.test;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Car {
	
	@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String carModel;

	
	/*
	 * Note: By default the 
	 * -->LAZY fetching for OneToMany and ManyToMany
	 * -->EAGER fetching OneToOne and ManyToOne
	 * by declaring this @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	 * we can achieve.
	 * 
	 * eager will; fetch all the entity data from the query,
	 * lazy will fetch if the entity is called that time
	 * eg: car to engine,
	 * with eager, car and engine will call
	 * with lazy, car will call first, if we call engine it will fetch
	 */
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(
	        name = "Join Table",
	        joinColumns = @JoinColumn(name = "car_id"),
	        inverseJoinColumns = @JoinColumn(name = "engine_id"))
	private List<Engine> engine=new ArrayList<Engine>();
	
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
		return engine;
	}
	public void setEngine_list(List<Engine> engine_list) {
		this.engine = engine_list;
	}
	@Override
	public String toString() {
		return "Car [Id=" + Id + ", carModel=" + carModel + "]";
	}
	
	

}
