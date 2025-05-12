package com.spring.boot.security.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.boot.security.proj.model.Employee;
import com.spring.boot.security.proj.model.EmployeeDetails;
import com.spring.boot.security.proj.repo.EmployeeRepo;

@Service
public class EmpServiceWC implements UserDetailsService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("User name : " + username);
		Employee details = employeeRepo.findByName(username);

		if (details == null) {
			System.out.println("User not found...");
			throw new UsernameNotFoundException("User not found...");
		}
		return new EmployeeDetails(details);
	}

}
