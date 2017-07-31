package spring.example.forms.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	private int id;
	@Size(min = 4, max = 15, message = "Login must be between 4 and 15 characters long")
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Must contain only chars and numbers")
	private String login;
	@Size(min = 10, max = 255, message = "Description must be between 10 and 255 characters long")
	private String description;
	@Size(min = 6, max = 15, message = "Password must be between 6 and 15 characters long")
	private String password;
	private Set<Task> tasks = new HashSet<Task>();
	
	public User() {
		super();
	}

	public User(int id, String login, String description, String password) {
		super();
		this.id = id;
		this.login = login;
		this.description = description;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", description=" + description + ", password=" + password
				+ ", tasks=" + tasks + "]";
	}
}
