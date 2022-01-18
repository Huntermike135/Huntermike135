package com.revature.Handler;

import com.revature.Service.ReimbursementSerivce;
import com.revature.model.Reimbursements;
import com.revature.repository.ReimbursementsRepositoryImpl;

import io.javalin.http.Handler;

public class ReimbursementHandler {
	private ReimbursementSerivce reimburseService;

	public ReimbursementHandler() {
		reimburseService = new ReimbursementSerivce();
	}

	public Handler findAllReimbursements = ctx -> {

		System.out.println("Find all reimbursements.");
		ctx.json(reimburseService.findAllReimbursements());
	};

	public Handler findPendingReimbursements = ctx -> {

		System.out.println("Find all Pending.");
		ctx.json(reimburseService.findPendingReimbursements());
	};

	public Handler findAllReimbursementsByUsername = ctx -> {
		System.out.println("Find all username.");
	};

	public Handler createReimbursement = ctx -> {
		System.out.println("Create reimbursements.");

		System.out.println(ctx.body());
		Reimbursements retrievedReimbursement = ctx.bodyAsClass(Reimbursements.class);
		System.out.println(retrievedReimbursement);
		reimburseService.createReimbursement(retrievedReimbursement);
		;
	};
	public Handler updateReimbursementStatus = ctx -> {

		System.out.println("Update Status.");
		Reimbursements r = ctx.bodyAsClass(Reimbursements.class);
		ReimbursementsRepositoryImpl repo = new ReimbursementsRepositoryImpl();
		if (r.getStatus().equals("Approved") || r.getStatus().equals("Denied")) {
			repo.updateReimbursementStatus(r);
			//Logger myLogger = LoggerFactory.getLogger("infoLogger");
			if(r.getStatus().equals("Approved")) {
				System.out.println("Reimbursement request for " + r.getReason().toLowerCase() + " submitted by " + r.getEmpName() + " has been approved");
				ctx.html("Reimbursement request for " + r.getReason().toLowerCase() + " submitted by " + r.getEmpName() + " has been approved");
			} else if (r.getStatus().equals("Denied")) {
				System.out.println("Reimbursement request for " + r.getReason().toLowerCase() + " submitted by " + r.getEmpName() + " has been denied");
				ctx.html("Reimbursement request for " + r.getReason().toLowerCase() + " submitted by " + r.getEmpName() + " has been denied");
			} // End else if statement
		} else {
			ctx.html("Action failed");
		} // End else statement
	}; // End 
}
	
	
