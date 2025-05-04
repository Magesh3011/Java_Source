package com.spring.boot.security.proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.security.proj.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private Employee employee;

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1, "Alice", "Developer"));
		employees.add(new Employee(2, "Bob", "Tester"));
		employees.add(new Employee(3, "Charlie", "Manager"));
		employees.add(new Employee(4, "Diana", "Designer"));
		employees.add(new Employee(5, "Evan", "DevOps"));
		// TODO Auto-generated method stub

		return employees;
	}

}
