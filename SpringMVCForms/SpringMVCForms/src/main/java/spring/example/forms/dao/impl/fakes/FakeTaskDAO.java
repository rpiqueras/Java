package spring.example.forms.dao.impl.fakes;

import java.util.ArrayList;
import java.util.List;

import spring.example.forms.dao.TaskDAO;
import spring.example.forms.models.Task;

public class FakeTaskDAO implements TaskDAO{

	private List<Task> mockDB;
	
	public FakeTaskDAO() {
		init();
	}

	private void init(){
		mockDB = new ArrayList<Task>();
	}
	
	public int create(Task task) {
		task.setId(mockDB.size() +1);
		mockDB.add(task);
		
		return task.getId();
	}

	public Task selectById(Integer id) {
		List<Task> tasks= selectAll();
		Task selectedUser = null;
		
		for(Task t : tasks){
			if(t.getId() == id) selectedUser = t;
		}
		
		return selectedUser;
	}

	public List<Task> selectAll() {
		return mockDB;
	}

	public void delete(Integer id) {
		List<Task> tasks= selectAll();
		
		for(Task t : tasks){
			if(t.getId() == id){
				tasks.remove(t);
				return;
			}
		}
	}

	public void update(Integer id, Task task) {
		List<Task> tasks= selectAll();
		
		for(int i=0; i<tasks.size(); i++){
			if(tasks.get(i).getId() == id){
				tasks.set(i, task);
				return;
			}
		}
	}

}