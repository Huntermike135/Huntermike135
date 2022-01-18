package com.revature.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.revature.model.User;
import com.revature.model.UserLogin;
import com.revature.util.HibernateSessionFactory;

public class UserRepositoryImpl implements UserRepository{

//	@Override
//	public void save(User user) {
//		
//		Session session = null;
//		Transaction transaction = null;
//		
//		try {
//			session = HibernateSessionFactory.getSession();
//			transaction = session.beginTransaction();
//			session.save(user);
//			transaction.commit();
//		}catch(HibernateException e) {
//			transaction.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//		
//	}

//	@Override
//	public UserLogin userLogin(UserLogin user) {
//		UserLogin user1 = null;
//		
//		Transaction tx = null;
//        try(
//                Session session = HibernateSessionFactory.getSession();
//                ){
//            tx = session.beginTransaction();
//            user1 = session.createQuery("FROM app_user AS L WHERE L.username = :username AND L.password = :password", User.class)
//                    .setParameter("username", user.getUsername()).setParameter("password", user.getPassword()).getSingleResult();
//            tx.commit();
//        }catch(HibernateException e){
//            if(tx != null)
//                if(!tx.isActive()) tx.rollback();
//           // dLog.error(e.getMessage(), e);
//        }
//        if(user1 != null) System.out.println("Successful retrieval of LoginInfoEntity from Database: " + user1);
//        else System.out.println("Failed retrieval of LoginInfoEntity from Database: " + user);
//        return user1;
//		
//		Session session = null;
//		Transaction transaction = null;
//		
//		try {
//			session = HibernateSessionFactory.getSession();
//			transaction = session.beginTransaction();
//			user1 = session.get(User.class, user);
//		} catch(HibernateException e) {
//			transaction.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close(); 
//		} // End finally block
//		return user;
//	} // End method

	@Override
	public void save(UserLogin user) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
	}

@Override
public UserLogin userLogin(UserLogin user) {
	// TODO Auto-generated method stub
	return null;
}
}
//	@Override
//	public UserLogin userLogin(UserLogin user) {
//		// TODO Auto-generated method stub
//		UserLogin auth = null;
//		Session session = null;
//		Transaction transaction = null;
//		
//		try {
//			session = HibernateSessionFactory.getSession();
//			transaction = session.beginTransaction();
//			auth = session.get(UserLogin.class, user);
//		} catch(HibernateException e) {
//			transaction.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close(); 
//		} // End finally block
//		return user;
//	} // End method
//	
//    }



