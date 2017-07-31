package models;

public class GreetingEngine {

	private Greet greet;
	private int times;
	
	public GreetingEngine() {
		super();
	}

	public GreetingEngine(Greet greet) {
		super();
		this.greet = greet;
	}
	
	public String greetMe(){
		String greetResult = "";
		
		for(int i=0;i<times;i++){
			greetResult += greet.getGreeting() + " ";
		}
		
		return greetResult;
	}

	public Greet getGreet() {
		return greet;
	}

	public void setGreet(Greet greet) {
		this.greet = greet;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "GreetingEngine [greet=" + greet + ", times=" + times + "]";
	}
}
