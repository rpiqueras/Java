package CarExample;


public class Car implements Vehicle {
	
	private int petrolTank;
	
	public void move() {
		if(petrolTank > 0) petrolTank--;
	}

}
