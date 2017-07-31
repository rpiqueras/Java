package spring.example.rest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Series {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String numberOfEpisodes;
	private String dateReleased;
	private String country;
	
	public Series() {
		super();
	}

	public Series(int id, String title, String numberOfEpisodes, String dateReleased, String country) {
		super();
		this.id = id;
		this.title = title;
		this.numberOfEpisodes = numberOfEpisodes;
		this.dateReleased = dateReleased;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	public void setNumberOfEpisodes(String numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}

	public String getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(String dateReleased) {
		this.dateReleased = dateReleased;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Series [id=" + id + ", title=" + title + ", numberOfEpisodes=" + numberOfEpisodes + ", dateReleased="
				+ dateReleased + ", country=" + country + "]";
	}
}