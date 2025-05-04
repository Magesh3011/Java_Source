package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.security.proj.model.Employee;

@RestController
public class Verify {

	@PostMapping("/login")
	public Employee login(@RequestBody Employee verifyEmp) {

		return verifyEmp;
	}

}
