package FootballExampleAnnotations;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Match {

	@Autowired
	@Qualifier("osasuna")
	private Team homeTeam;
	@Autowired
	@Qualifier("erreala")
	private Team visitorTeam;
	@Autowired
	@Qualifier("undiano")
	private Referee referee;
	@Autowired
	private Home stadium;
	private Date date;
	private int homeGoal;
	private int visitorGoal;
	
	public Match() {
		super();
	}
	
	public String outcome(){
		return homeTeam.getName() + " " + homeGoal + " - " + visitorTeam.getName() + " " + visitorGoal;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getVisitorTeam() {
		return visitorTeam;
	}

	public void setVisitorTeam(Team visitorTeam) {
		this.visitorTeam = visitorTeam;
	}

	public Referee getReferee() {
		return referee;
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	public Home getStadium() {
		return stadium;
	}

	public void setStadium(Home stadium) {
		this.stadium = stadium;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHomeGoal() {
		return homeGoal;
	}

	public void setHomeGoal(int homeGoal) {
		this.homeGoal = homeGoal;
	}

	public int getVisitorGoal() {
		return visitorGoal;
	}

	public void setVisitorGoal(int visitorGoal) {
		this.visitorGoal = visitorGoal;
	}

	@Override
	public String toString() {
		return "Match [homeTeam=" + homeTeam + ", visitorTeam=" + visitorTeam + ", referee=" + referee + ", stadium="
				+ stadium + ", date=" + date + ", homeGoal=" + homeGoal + ", visitorGoal=" + visitorGoal + "]";
	}
}
