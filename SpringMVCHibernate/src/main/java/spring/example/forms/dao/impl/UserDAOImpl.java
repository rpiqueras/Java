package spring.example.forms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import spring.example.forms.dao.UserDAO;
import spring.example.forms.models.User;

public class UserDAOImpl implements UserDAO{
	

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

	@Transactional
	public int insert(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(readOnly = true)
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional(readOnly = true)
	public List<User> selectByLogin(String login){
		List<User> users = null;
		Query query = (Query) getSession().createQuery("FROM User u where u.login LIKE :login");
		query.setParameter("login", "%" + login + "%");
		users = query.getResultList();
		
		return users;
	}
}
