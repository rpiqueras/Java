package spring.example.rest.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import spring.example.rest.dao.SeriesDAO;
import spring.example.rest.models.Series;

public class SeriesDAOImpl extends HibernateBaseDAO implements SeriesDAO{
	
	@Transactional
	public int create(Series series) {
		int id = (Integer) getSession().save(series);
		series.setId(id);
		return id;
	}

	@Transactional(readOnly = true)
	public Series find(Integer id) {
		Series series = (Series) getSession().get(Series.class, id);
		return series;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Series> get() {
		List<Series> series = null;
		series = getSession().createQuery("FROM Series").list();
		return series;
	}

	@Transactional
	public void delete(Integer id) {
		Series series = (Series) getSession().load(Series.class, id);
		getSession().delete(series);
	}

	@Transactional
	public Series update(Series series) {
		return (Series) getSession().merge(series);
	}
}