package spring.example.rest.dao;

import java.util.List;

import spring.example.rest.models.Series;

public interface SeriesDAO {
	
	public int create(Series series);
	public Series find(Integer id);
	public List<Series> get();
	public void delete(Integer id);
	public Series update(Series series);
}
