package com.revature.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Employee;
import com.revature.util.HibernateSessionFactory;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Override
	public Employee findById(int id) {
		Employee emp = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			emp = session.get(Employee.class, id);
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return emp;
	}

	@Override
	public Employee findByUsername(String username) {
		Employee emp = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			emp = session.get(Employee.class, username);
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return emp;
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> employee = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			employee = session.createQuery("FROM Employee", Employee.class).getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		} 
		return employee;
	}

	@Override
	public Employee login(Employee login) {
		Employee returnLoginInfo = null;
        Transaction tx = null;
        try(
                Session session = HibernateSessionFactory.getSession();
                ){
            tx = session.beginTransaction();
            returnLoginInfo = session.createQuery("FROM Employee WHERE employee_username = :username AND employee_password = :password", Employee.class)
                   .setParameter("username", login.getUsername()).setParameter("password", login.getPassword()).getSingleResult();
           //String SQL = "SELECT * FROM Employee WHERE username = ? AND password = ?";
         
            tx.commit();
        }catch(HibernateException e){
            if(tx != null)
                if(!tx.isActive()) tx.rollback();
           //System.out.println(e.getMessage(), e); 
        }
        if(returnLoginInfo != null) System.out.println("Successful retrieval of LoginInfoEntity from Database: " + returnLoginInfo);
        else System.out.println("Failed retrieval of LoginInfoEntity from Database: " + login);
        return returnLoginInfo;
    }
}


