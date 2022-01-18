package com.revature.repository;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeRepository {
	Employee findById(int id);

	Employee findByUsername(String username);

	List<Employee> findAllEmployee();
	
	Employee login(Employee login);

}