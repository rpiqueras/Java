package jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jdbc.dao.impl.ClientDAOImpl;
import jdbc.models.Client;

public class MainJdbcExample {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beansJDBCExample.xml");
		ClientDAOImpl clientDAO = (ClientDAOImpl) context.getBean("clientJDBCTemplate");
		System.out.println("Creating clients.........");
		
		clientDAO.insert("Paco", "Spain", "666555444", 32);
		clientDAO.insert("John", "UK", "666777888", 45);
		clientDAO.insert("Mauro", "Italy", "654654654", 15);
		clientDAO.insert("Eugenia", "Spain", "678678678", 30);
		System.out.println();
		
		selectAllClients(clientDAO);
		System.out.println("Updating client with ID = 3.........");
		
		clientDAO.update(3, "Peter");
		System.out.println();
		
		System.out.println("Listing client with ID = 3.........");
		Client client = clientDAO.selectById(3);
		
		System.out.println("ID: " + client.getId());
		System.out.println(", Name: " + client.getName());
		System.out.println();
		
		System.out.println("Deleting client with ID=1.........");
		clientDAO.delete(1);
		selectAllClients(clientDAO);
	}
	
	private static void selectAllClients(ClientDAOImpl clientDAO){
		System.out.println("Listing clients........");
		List<Client> clients = clientDAO.selectAll();
		for(Client client: clients){
			System.out.println("ID: " + client.getId());
			System.out.println(", Name: " + client.getName());
			System.out.println(", Country: " + client.getCountry());
			System.out.println(", Phone: " + client.getPhone());
			System.out.println(", Age: " + client.getAge());
			System.out.println();
		}
	}
}
