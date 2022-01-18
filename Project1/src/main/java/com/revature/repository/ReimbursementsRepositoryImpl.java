package com.revature.repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.revature.util.HibernateSessionFactory;
import com.revature.model.Reimbursements;

public class ReimbursementsRepositoryImpl implements ReimbursementRepository {

	@Override
	public void createReimbursement(Reimbursements reimbursement) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(reimbursement); 
			transaction.commit();
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close(); 
		} 
	} 
	
	@Override
	public List<Reimbursements> findAllReimbursements() {
		List<Reimbursements> reimbursements = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			reimbursements = session.createQuery("FROM Reimbursements", Reimbursements.class).getResultList();
			transaction.commit();
		} catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close(); 
		} // End finally block
		return reimbursements;
	}
	@Override
	public List<Reimbursements> findPendingReimbursements () {
		
			List<Reimbursements> reimbursements = null;
			Session session = null;
			Transaction transaction = null;
			
			try {
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();
				
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<Reimbursements> cq = cb.createQuery(Reimbursements.class);
				Root<Reimbursements> root = cq.from(Reimbursements.class);
				
				cq.select(root).where(cb.equal(root.get("status"), "pending"));
				Query<Reimbursements> query = session.createQuery(cq);
				
				reimbursements = query.getResultList();
				
				transaction.commit();
			} catch(HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			}  finally {
				session.close(); 
			} 
			return reimbursements;
		} 


	@Override
	public List<Reimbursements> findReimbursementsByEmployeeUserName(String username) {
		List<Reimbursements> reimbursements = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Reimbursements> cq = cb.createQuery(Reimbursements.class);
			Root<Reimbursements> root = cq.from(Reimbursements.class);
			
			cq.select(root).where(cb.equal(root.get("empUserName"), username));
			Query<Reimbursements> query = session.createQuery(cq);
			
			reimbursements = query.getResultList();
			
			transaction.commit();
		} catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}  finally {
			session.close(); 
		} 
		return reimbursements;
	} 

	@Override
	public void updateReimbursementStatus(Reimbursements reimbursement) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(reimbursement);
			transaction.commit();
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close(); 
		} 
	}

}
