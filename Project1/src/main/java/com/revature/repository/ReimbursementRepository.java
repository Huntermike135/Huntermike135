package com.revature.repository;

import java.util.List;

import com.revature.model.Reimbursements;

public interface ReimbursementRepository {
	void createReimbursement(Reimbursements reimbursement);
	
	List<Reimbursements> findAllReimbursements();

	List<Reimbursements> findPendingReimbursements ();
	
	List<Reimbursements> findReimbursementsByEmployeeUserName(String username);

	public void updateReimbursementStatus(Reimbursements reimbursement);
}
