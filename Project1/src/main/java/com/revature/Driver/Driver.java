package com.revature.Driver;

import javax.servlet.http.HttpSession;

import com.revature.controller.EmployeeController;
import com.revature.controller.ReimbursementController;
import com.revature.util.JavalinConfig;

import io.javalin.Javalin;

public class Driver {
	public static void main(String[] args) {
		Javalin app = Javalin.create(config ->
		config.enableCorsForAllOrigins()).start(7500);
		//System.out.println(ctx.req.getHeaderNames());
//		Javalin app = Javalin.create().start(7500);
//
//		JavalinConfig config = new JavalinConfig(app).configureStaticResources();
		EmployeeController employeeController = new EmployeeController(app);
		employeeController.initEndpoints();
		ReimbursementController reimbursementController = new ReimbursementController(app);
		reimbursementController.initEndpoints();

		app.post("/session", ctx -> {
			ctx.req.getSession();
			System.out.println("seeions started");
			//System.out.println(ctx.req.getHeaderNames());
			//while(requestHeaders.hasMoreElements());
			//requestHeaders.nextElement();
		});
		app.get("/locked-resource", ctx -> {
			HttpSession session = ctx.req.getSession();
			if (session == null)
				ctx.res.getWriter().write("You are authenticated");
			else
				ctx.res.getWriter().write("You cannot access this resource");
			System.out.println("locked");
		});
		app.get("/logout", ctx -> {
			HttpSession session = ctx.req.getSession(false);
			if (session != null)
				session.invalidate();
			System.out.println("logout");
		});

	}
}

