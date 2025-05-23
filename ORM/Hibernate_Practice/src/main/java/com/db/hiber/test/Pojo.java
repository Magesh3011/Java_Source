package com.db.hiber.test;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pojo {

	private String name;
	private int age;
	@Id
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Pojo [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	
	
	
}
