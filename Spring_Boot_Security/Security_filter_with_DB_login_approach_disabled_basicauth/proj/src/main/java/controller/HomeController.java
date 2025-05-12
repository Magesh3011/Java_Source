package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/addemployee")
	public void addEmployee(@RequestBody Employee employee) {

		employeeService.addEmployee(employee);
	}

	@PostMapping("/loginuser")
	public String login(@RequestBody Employee verifyEmp) {
		// return "Log in success";
		return employeeService.loginVerify(verifyEmp);
	}
}
