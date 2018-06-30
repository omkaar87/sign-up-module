package com.mcq.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcq.user.ResetPassword;

/**
 * @author Omkar Shivadekar
 * Date : 29-Jun-2018
 * Time : 2:54:56 PM
 */

@Repository("userRepository")
public class UserRepoImpl implements UserRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ResetPassword> findByEmail(String email) {

		Session session = sessionFactory.getCurrentSession();
		
		Query<ResetPassword> theQuery = session.createQuery("from ResetPassword where email=?",ResetPassword.class);
		
		theQuery.setParameter(0, email);
		
		List result = theQuery.getResultList();
		
		return result;
	}

	@Override
	public List<ResetPassword> findByResetToken(String resetToken) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<ResetPassword> theQuery = session.createQuery("from ResetPassword where resetToken=:token",ResetPassword.class);
		
		theQuery.setParameter("token", resetToken);
		
		List result = theQuery.getResultList();
		
		return result;
	}

	@Override
	public void saveUserDetails(ResetPassword rs) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(rs);

	}

	@Override
	public List getUserName(String token) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<ResetPassword> theQuery = currentSession.createQuery("from ResetPassword where resetToken=?",ResetPassword.class);

		theQuery.setParameter(0, token);
		
		List result = theQuery.getResultList();
		
		System.out.println(result.get(0));
		
		return null;
	}

}
