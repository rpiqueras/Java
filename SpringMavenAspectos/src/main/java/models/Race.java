package models;

import java.util.Vector;

public class Race {

	private String name;
	private Circuit circuit;
	private Vector<Kart> karts = new Vector<Kart>();
	private Vector<Kart> finished = new Vector<Kart>();
	
	public Race() {
		super();
	}
	
	public void run(){
		do{
			for(int i=0;i<karts.size();i++){
				moveKart(karts.elementAt(i));
				if(isFinished(karts.elementAt(i))){
					moveToFinished(karts.elementAt(i));
				}
			}
		} while(notAllFinished());
	}
	
	public String showResult(){
		String result = "Race: " + this.getName() + "\n";
		result += "Circuit: " + circuit.toString() +"\n";
		for(int i=0;i<finished.size();i++){
			result += (i+1) + ".-" + finished.elementAt(i).toString() + "\n";
		}
		
		return result;
	}
	
	private void moveKart(Kart kart){
		int movedPositions = 0;
		
		movedPositions = kart.move() - (circuit.difficulty() - kart.handle());
		kart.setPosition(kart.getPosition() + movedPositions);
	}
	
	private void moveToFinished(Kart kart){
		finished.add(kart);
		karts.removeElement(kart);
	}
	
	private boolean isFinished(Kart kart){
		return kart.getPosition() >= circuit.getDistance();
	}
	
	private boolean notAllFinished(){
		return karts.size() > 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}

	public Vector<Kart> getKarts() {
		return karts;
	}

	public void setKarts(Vector<Kart> karts) {
		this.karts = karts;
	}

	public Vector<Kart> getFinished() {
		return finished;
	}

	public void setFinished(Vector<Kart> finished) {
		this.finished = finished;
	}

	@Override
	public String toString() {
		return "Race [name=" + name + ", circuit=" + circuit + ", karts=" + karts + ", finished=" + finished + "]";
	}
}
