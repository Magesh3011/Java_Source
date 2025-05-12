package com.spring.boot.security.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.boot.security.proj.model.Employee;
import com.spring.boot.security.proj.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	AuthenticationManager authenticationManager;

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

	public String loginVerify(Employee verifyEmp) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(verifyEmp.getName(), verifyEmp.getPassword()));

		if (authentication.isAuthenticated()) {
			return "Success";
		}
		return "Fail";
		/*
		 * Meaning step by step: 1️⃣ verifyEmp.getName() and verifyEmp.getPassword()
		 * verifyEmp is probably your employee or user object (maybe fetched from a form
		 * or API request).
		 * 
		 * You are getting the username and password the user provided during login.
		 * 
		 * 2️⃣ new UsernamePasswordAuthenticationToken(...) This creates an
		 * authentication token using the provided username and password.
		 * 
		 * Think of this like a login form object:
		 * 
		 * principal = username
		 * 
		 * credentials = password
		 * 
		 * Example:
		 * 
		 * java Copy Edit new UsernamePasswordAuthenticationToken("john", "1234"); 3️⃣
		 * authenticationManager.authenticate(...) This line is where actual
		 * authentication happens in Spring Security.
		 * 
		 * Here's what Spring does under the hood:
		 * 
		 * It takes the username and password from your token.
		 * 
		 * Passes them to the configured AuthenticationProvider (like your
		 * DaoAuthenticationProvider).
		 * 
		 * The provider will:
		 * 
		 * Load user details using UserDetailsService.
		 * 
		 * Compare passwords (using your configured password encoder).
		 * 
		 * If everything matches, it returns an authenticated Authentication object
		 * (meaning login success).
		 * 
		 * If login fails (wrong password or user not found), it throws an
		 * AuthenticationException.
		 * 
		 * 4️⃣ Result: If login is successful:
		 * 
		 * authentication object will have user details + roles/authorities.
		 * 
		 * authentication.isAuthenticated() will return true.
		 * 
		 * If login fails:
		 * 
		 * An exception will be thrown, and you should handle it.
		 */

	}

}
