package FootballExampleAnnotations;

public class Home {

	private String name;
	private int capacity;
	
	public Home() {
		super();
	}

	public Home(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Home [name=" + name + ", capacity=" + capacity + "]";
	}
}
