package com.revature.Service;

import java.util.List;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;
import com.revature.repository.EmployeeRepositoryImpl;

public class EmployeeService {
	
	private EmployeeRepository empRepo = new EmployeeRepositoryImpl();

	public Employee findById(int id) {
		return this.empRepo.findById(id);
	}

	public Employee findByUsername(String username) {
		return this.empRepo.findByUsername(username);
	}

	public List<Employee> findAllEmployee() {
		return this.empRepo.findAllEmployee();
	}
	
	public Employee login(Employee login) {
		return this.empRepo.login(login);
	}

	
}
