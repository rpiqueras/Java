package spring.example.forms.dao;

import java.util.List;

import spring.example.forms.models.User;

public interface UserDAO {

	public int create(User user);
	public User selectById(Integer id);
	public List<User> selectAll();
	public void delete(Integer id);
	public void update(Integer id, User user);
}
