package spring.example.forms.dao.impl.fakes;

import java.util.ArrayList;
import java.util.List;

import spring.example.forms.dao.UserDAO;
import spring.example.forms.models.User;

public class FakeUserDAO implements UserDAO{

	private List<User> mockDB;
	
	public FakeUserDAO() {
		init();
	}

	private void init(){
		mockDB = new ArrayList<User>();
		User user1 = new User(1, "sjobs", "Apple CEO", "stewie");
		User user2 = new User(2, "lellison", "Oracle CEO", "larry");
		User user3 = new User(3, "bgates", "Microsoft CEO", "imrich");
		User user4 = new User(4, "mzuckerberg", "Facebook CEO", "selfie");
		
		mockDB.add(user1);
		mockDB.add(user2);
		mockDB.add(user3);
		mockDB.add(user4);
	}
	
	public int create(User user) {
		user.setId(mockDB.size() +1);
		mockDB.add(user);
		
		return user.getId();
	}

	public User selectById(Integer id) {
		List<User> users= selectAll();
		User selectedUser = null;
		
		for(User u : users){
			if(u.getId() == id) selectedUser = u;
		}
		
		return selectedUser;
	}

	public List<User> selectAll() {
		return mockDB;
	}

	public void delete(Integer id) {
		List<User> users= selectAll();
		
		for(User u : users){
			if(u.getId() == id){
				users.remove(u);
				return;
			}
		}
	}

	public void update(Integer id, User user) {
		List<User> users= selectAll();
		
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getId() == id){
				users.set(i, user);
				return;
			}
		}
	}

}
