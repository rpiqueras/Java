package FightExample;

public class Combat {
	private Javamon javamon1;
	private Javamon javamon2;
	private int assaults = 0;
	
	public Combat() {
	}
	
	public void combat(){
		Javamon first, second;
		do{
			assaults++;
			
			if(javamon1.initiative() < javamon2.initiative()){
				first = javamon2;
				second = javamon1;
			}else{
				first = javamon1;
				second = javamon2;
			}
			System.out.println(first.status() + " -> attacks -> " + second.status());
			assault(first, second);
		}while(first.getLife() > 0 && second.getLife() > 0);
	}
	
	private void assault(Javamon jm1, Javamon jm2){
		int damage = (jm1.attack() - jm2.defend());
		if(damage > 0){
			System.out.println(jm1.getName() + " -> makes " + damage + " damage to -> " + jm2.getName());
			jm2.setLife(jm2.getLife() - damage);
		}else{
			System.out.println(jm2.getName() + " stops the attack!");
		}
	}
	
	public Javamon outcome(){
		System.out.println("Total " + assaults + " assaults");
		if(javamon1.getLife() > 0){
			return javamon1;
		}else{
			return javamon2;
		}
	}

	public Javamon getJavamon1() {
		return javamon1;
	}

	public void setJavamon1(Javamon javamon1) {
		this.javamon1 = javamon1;
	}

	public Javamon getJavamon2() {
		return javamon2;
	}

	public void setJavamon2(Javamon javamon2) {
		this.javamon2 = javamon2;
	}
}
