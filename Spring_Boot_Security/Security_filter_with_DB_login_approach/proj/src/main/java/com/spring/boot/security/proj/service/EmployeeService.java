package com.spring.boot.security.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.boot.security.proj.model.Employee;
import com.spring.boot.security.proj.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public List<Employee> getEmployees() {

		return employeeRepo.findAll();
	}

	public void addEmployee(Employee addemployee) {
		// TODO Auto-generated method stub

		addemployee.setPassword(bCryptPasswordEncoder.encode(addemployee.getPassword()));
		;
		employeeRepo.save(addemployee);
	}

}
