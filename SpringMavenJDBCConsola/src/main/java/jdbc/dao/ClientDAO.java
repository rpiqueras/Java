package jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import jdbc.models.Client;

public interface ClientDAO {

	public void setDataSource(DataSource ds);
	public void insert(String name, String country, String phone, Integer age);
	public Client selectById(Integer id);
	public List<Client> selectAll();
	public void delete(Integer id);
	public void update(Integer id, String name);
}
