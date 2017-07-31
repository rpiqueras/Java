package org.hibernate.example.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.example.dao.CustomerDAO;
import org.hibernate.example.dao.HibernateSession;
import org.hibernate.example.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	public Customer selectById(Long id) {
		Session session = openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		closeSession(session);
		
		return customer;
	}

	public List<Customer> selectAll() {
		Session session = openSession();
		List<Customer> customers = session.createCriteria(Customer.class).list();
		closeSession(session);
		
		return customers;
	}

	public void insert(Customer customer) {
		Session session = openSession();
		session.beginTransaction();
		Long id = (Long) session.save(customer);
		customer.setId(id);
		session.getTransaction().commit();
		closeSession(session);
	}

	public void update(Customer customer) {
		Session session = openSession();
		session.beginTransaction();
		session.merge(customer);
		session.getTransaction().commit();
		closeSession(session);
	}

	public void delete(Customer customer) {
		Session session = openSession();
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		closeSession(session);
	}

	private Session openSession(){
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		return sessionFactory.openSession();
	}
	
	private void closeSession(Session session){
		session.close();
	}
}
