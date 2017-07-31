package models;

public class Greet {

	private String greeting;

	public Greet() {
		super();
	}

	public Greet(String greeting) {
		super();
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "Greet [greeting=" + greeting + "]";
	}
}
