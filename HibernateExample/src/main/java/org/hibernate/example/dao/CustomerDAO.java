package org.hibernate.example.dao;

import java.util.List;

import org.hibernate.example.model.Customer;

public interface CustomerDAO {

	public Customer selectById(Long id);
	public List<Customer> selectAll();
	public void insert(Customer customer);
	public void update(Customer customer);
	public void delete(Customer customer);
}
