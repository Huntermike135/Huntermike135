package com.revature.controller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import com.revature.Handler.EmployeeHandler;

import io.javalin.Javalin;

public class EmployeeController {
	private Javalin app;
	private EmployeeHandler employeeHandler;

	public EmployeeController(Javalin app) {
		this.app = app;
		this.employeeHandler = new EmployeeHandler();
	}
	public void initEndpoints() {
		//The EndpointGroup defined by Javalin is a functional interface, so we pass in
		//a lambda expression to the "routes" method. An endpoint group is a group of
		//endpoints (defined using get(), post(), etc.).
	
		this.app.routes(() -> {
			// We start by defining the prefix for all of the routes related to ingredients.
			path("/employee", () -> {
				//We can now define our subroutes inside of this lambda expression:
				path("/all", () -> {
					//This endpoint should return all ingredients
					//We want this to be a get request, so...
					get(this.employeeHandler.findAllEmployee);
				});
				
				path("/login", () -> {
					//This endpoint should allow the client to add a new ingredient to our DB
					post(this.employeeHandler.login);
				});
			
				/*
				 * We have defined a path variable that we referring to as "id" here.
				 * This allows to client to pass back different ids to search for a
				 * particular ingredients.
				 */
				path("/id/{id}", () -> {
					get(this.employeeHandler.findById);
				});
			});
		});
	}
}
	
	
	

