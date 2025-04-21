package com.db.hiber.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Alien_Table")
public class Pojo {

	//with the nullable = false, can not update the value as null.
	@Column(name="User Name",nullable = false)
	private String name;
	@Column(name="User Age",nullable = false)
	private int age;
	
	//
	@Id
	@Column(name="User ID")
	//@GeneratedValue help to generate primary key automatically, we no need to give the vlaue, like AUTO there is some options
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//
	
	
	//Transient will not update column in the DB.
	@Transient
	private int mobNum;
	
	
	public int getMobNum() {
		return mobNum;
	}
	public void setMobNum(int mobNum) {
		this.mobNum = mobNum;
	}
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
		return "Pojo [name=" + name + ", age=" + age + ", id=" + id + ", mobNum=" + mobNum + "]";
	}
	
	
	
	
}
