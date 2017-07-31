package spring.example.rest.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class HibernateBaseDAO {
	
	protected SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	protected void handleException(HibernateException he){
		System.err.println("Hibernate exception: " + he.getMessage());
	}
}
