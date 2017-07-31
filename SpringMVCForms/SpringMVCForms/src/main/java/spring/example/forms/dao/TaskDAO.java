package spring.example.forms.dao;

import java.util.List;

import spring.example.forms.models.Task;

public interface TaskDAO {

	public int create(Task task);
	public Task selectById(Integer id);
	public List<Task> selectAll();
	public void delete(Integer id);
	public void update(Integer id, Task task);
}
