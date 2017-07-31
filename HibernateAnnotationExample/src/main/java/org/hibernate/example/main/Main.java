package org.hibernate.example.main;

import java.util.List;

import org.hibernate.example.dao.CustomerDAO;
import org.hibernate.example.dao.impl.CustomerDAOImpl;
import org.hibernate.example.model.Customer;

public class Main {

	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		showAll(customerDAO);
		
		Customer newCustomer = new Customer("Bill Gates", "Money street, Seattle", "bill@bills.com");
		customerDAO.insert(newCustomer);
		System.out.println("Inserted id: " + newCustomer.getId());
		
		newCustomer = new Customer("Steve Jobs", "Vegan street, Palo Alto", "isteve@apple.com");
		customerDAO.insert(newCustomer);
		System.out.println("Inserted id: " + newCustomer.getId());
		
		System.out.println("\nShow data after new insert");
		showAll(customerDAO);
		
		Customer oneCustomer = customerDAO.selectById(Long.valueOf(1));
		System.out.println("\nShow the customer with Id=1");
		System.out.println("Selected name: " + oneCustomer.getName());
		
		newCustomer.setAddress("New street, Illinois");
		customerDAO.update(newCustomer);
		System.out.println("\nShow data after update");
		showAll(customerDAO);
		
		customerDAO.delete(newCustomer);
		System.out.println("\nShow data after deletion");
		showAll(customerDAO);
	}
	
	public static void showAll(CustomerDAO customerDAO){
		List<Customer> customers = customerDAO.selectAll();
		System.out.println("--- CUSTOMER --- table contents ------");
		
		for(Customer customer : customers){
			System.out.println("Id: " + customer.getId());
			System.out.println("Name: " + customer.getName());
			System.out.println("Address: " + customer.getAddress());
		}
		System.out.println("Total customers: " + customers.size());
	}

}
