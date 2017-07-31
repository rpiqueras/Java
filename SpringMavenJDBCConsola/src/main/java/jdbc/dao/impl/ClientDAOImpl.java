package jdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dao.ClientDAO;
import jdbc.mappers.ClientMapper;
import jdbc.models.Client;

public class ClientDAOImpl implements ClientDAO{

	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void insert(String name, String country, String phone, Integer age) {
		String SQL = "Insert into Client (name, country, phone, age) values (?, ?, ? ,?)";
		jdbcTemplateObject.update(SQL, name, country, phone, age);
		System.out.println("Created record name: " + name + " Country: " + country + " Phone: " + phone + " Age: " + age);
	}

	@Override
	public Client selectById(Integer id) {
		String SQL = "select * from Client where id=?";
		Client client = jdbcTemplateObject.queryForObject(SQL, new Object[] {id}, new ClientMapper());
		return client;
	}

	@Override
	public List<Client> selectAll() {
		String SQL = "select * from Client";
		List<Client> clients = jdbcTemplateObject.query(SQL, new ClientMapper());
		return clients;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Client where id=?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted record with Id: " + id);
	}

	@Override
	public void update(Integer id, String name) {
		String SQL = "update Client set name=? where id=?";
		jdbcTemplateObject.update(SQL, name, id);
		System.out.println("Updated record with Id: " + id);
	}

}
