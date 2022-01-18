package com.revature.Handler;

import com.revature.Service.EmployeeService;
import com.revature.model.Employee;
import com.revature.model.Reimbursements;
import com.revature.repository.EmployeeRepositoryImpl;

import io.javalin.http.Handler;

public class EmployeeHandler {
	private EmployeeService employeeService;

	public EmployeeHandler() {
		employeeService = new EmployeeService();
	}

	public Handler findAllEmployee = ctx -> {
		
		System.out.println("Find all employees.");
		//System.out.println(ctx.queryString());
		ctx.json(employeeService.findAllEmployee());
	};

	public Handler findByUsername = ctx -> {
		System.out.println("userlogin");
		

			
		}; 
	public Handler employeeLogin = ctx -> {
		System.out.println("userloginPass");

		System.out.println("login");
		//String empiD = ctx.formParam("employee_id");
		String name = ctx.formParam("employee_username");
		String pass = ctx.formParam("employee_password");

		EmployeeService repo = new EmployeeService();
		Employee user = repo.findByUsername(name);
		if (user == null) {
			System.out.println("Username not found");
		} else if (!pass.equals(user.getPassword())) {
			System.out.println("Password incorrect");
		} else {
			ctx.json(user);
		} // End else statement

	};
				
			 
		

	public Handler findById = ctx -> {
		// Proof of Concept
		System.out.println(ctx.pathParam("id"));
		Employee retrievedEmployee = employeeService.findById(Integer.parseInt(ctx.pathParam("id")));
		// Don't forget to write the ingredient to the response body as JSON.
		if (retrievedEmployee != null)
			ctx.json(retrievedEmployee);
		else
			ctx.res.getWriter().write("Sorry. No ingredients that match your search were found.");

	};
	public Handler login = ctx -> {
		System.out.println("Findlogin.");
		//System.out.println(ctx.body());
		Employee retrievedEmployee = ctx.bodyAsClass(Employee.class);
		System.out.println(retrievedEmployee );
		employeeService.login(retrievedEmployee );
    };
}

