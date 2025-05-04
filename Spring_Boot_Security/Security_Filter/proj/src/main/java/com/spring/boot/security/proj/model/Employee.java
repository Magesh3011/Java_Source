package com.spring.boot.security.proj.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int id;
	private String name;
	private String role;

	public int getId() {
		return id;
	}

	public Employee() {
		super();
	}

	public Employee(int id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
