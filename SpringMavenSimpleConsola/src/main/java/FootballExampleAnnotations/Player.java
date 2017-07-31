package FootballExampleAnnotations;

import java.util.Random;

public class Player {
	private String name;
	private int number;
	private String position;
	private int kick;
	private int pass;
	private int dodge;
	private Random random = new Random();
	
	public Player(){
		init();
	}

	public Player(String name, int number, String position) {
		super();
		this.name = name;
		this.number = number;
		this.position = position;
		init();
	}
	
	private void init(){
		this.kick = random.nextInt(6) + 1;
		this.pass = random.nextInt(6) + 1;
		this.dodge = random.nextInt(6) + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getKick() {
		return kick;
	}

	public void setKick(int kick) {
		this.kick = kick;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) {
		this.dodge = dodge;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", number=" + number + ", position=" + position + ", kick=" + kick + ", pass="
				+ pass + ", dodge=" + dodge + ", random=" + random + "]";
	}
}
