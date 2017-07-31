package FootballExampleAnnotations;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Team {

	private String name;
	private Hashtable<Integer, Player> players;
	@Autowired
	@Qualifier("sadar")
	private Home homeStadium;
	
	public Team() {
		super();
	}

	public Team(String name, Hashtable<Integer, Player> players, Home homeStadium) {
		super();
		this.name = name;
		this.players = players;
		this.homeStadium = homeStadium;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hashtable<Integer, Player> getPlayers() {
		return players;
	}

	public void setPlayers(Hashtable<Integer, Player> players) {
		this.players = players;
	}

	public Home getHomeStadium() {
		return homeStadium;
	}

	public void setHomeStadium(Home homeStadium) {
		this.homeStadium = homeStadium;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", players=" + players + ", homeStadium=" + homeStadium + "]";
	}
}
