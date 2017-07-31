package FootballExampleAnnotations;

public class Referee {

	private String name;
	private String country;
	
	public Referee() {
		super();
	}

	public Referee(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Referee [name=" + name + ", country=" + country + "]";
	}
}
