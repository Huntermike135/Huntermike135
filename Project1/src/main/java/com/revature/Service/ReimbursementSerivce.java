package com.revature.Service;

import java.util.List;

import com.revature.model.Reimbursements;
import com.revature.repository.ReimbursementRepository;
import com.revature.repository.ReimbursementsRepositoryImpl;

public class ReimbursementSerivce {
	private ReimbursementRepository reimRepo = new ReimbursementsRepositoryImpl();
	
	public void createReimbursement(Reimbursements reimbursement) {
	this.reimRepo.createReimbursement(reimbursement);
	}
	
	public List<Reimbursements> findAllReimbursements() {
		return this.reimRepo.findAllReimbursements();
	}

	public List<Reimbursements> findPendingReimbursements () {
		return this.reimRepo.findPendingReimbursements();
	}
	
	public List<Reimbursements> findReimbursementsByEmployeeUserName(String username) {
		return this.reimRepo.findReimbursementsByEmployeeUserName(username);
	}

	public void updateReimbursementStatus(Reimbursements reimbursement) {
		this.reimRepo.updateReimbursementStatus(reimbursement);
	}
}
