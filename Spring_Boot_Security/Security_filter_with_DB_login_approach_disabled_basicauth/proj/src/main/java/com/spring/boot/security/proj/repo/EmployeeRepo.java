package com.spring.boot.security.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.security.proj.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByName(String username);

}
