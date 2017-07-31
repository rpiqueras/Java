package models;

import java.util.Random;

public class Kart {

	private String name;
	private int speed;
	private int acceleration;
	private int grip;
	private int position;
	
	public Kart() {
		init();
	}
	
	private void init(){
		Random random = new Random();
		this.position = 0;
		this.speed = random.nextInt(18);
		this.acceleration = random.nextInt(18 - this.speed);
		this.grip = random.nextInt(18 - this.speed - this.acceleration);
	}
	
	public int move(){
		int result;
		Random random = new Random();
		result = this.speed + this.acceleration + random.nextInt(6);
		return result;
	}
	
	public int handle(){
		int result;
		Random random = new Random();
		result = this.grip + random.nextInt(6);
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public int getGrip() {
		return grip;
	}

	public void setGrip(int grip) {
		this.grip = grip;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Kart [name=" + name + ", speed=" + speed + ", acceleration=" + acceleration + ", grip=" + grip
				+ ", position=" + position + "]";
	}
}
