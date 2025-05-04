package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.security.proj.model.Employee;
import com.spring.boot.security.proj.service.EmployeeService;

@RestController
public class HomeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public String home() {

		return "Hello, welcvome to hoome page";
	}

	@GetMapping("/getemployee")
	public List<Employee> getEmployee() {

		return employeeService.getEmployees();

	}
}
