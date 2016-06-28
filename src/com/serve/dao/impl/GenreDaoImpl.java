package com.serve.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.serve.dao.GenreDao;
import com.serve.entity.Genre;


@Transactional
@Repository
public class GenreDaoImpl implements GenreDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addGenre(Genre genre) {		
		return ((Integer)sessionFactory.getCurrentSession().save(genre) > 0);
	}

	@Override
	public boolean deteleGenre(String name) {
		
		String hql = "delete Genre g where g.name = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, name);
		return (q.executeUpdate() > 0);
	}

	@Override
	public List<Genre> getGenreList() {
		
		String hql = "from Genre";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		
		return q.list();
	}

	@Override
	public boolean update(Genre genre) {
		
		String hql = "update Genre g set g.name = ?,g.description = ? where g.id= ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, genre.getName());
		q.setString(1, genre.getDescription());
		q.setInteger(2, genre.getId());
		
		return (q.executeUpdate() > 0);
	}

	@Override
	public String getDescriptionByName(String name) {
		
		String hql = "select new Genre(description) from Genre g where g.name = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, name);
		Genre g = (Genre)q.uniqueResult();
		
		return g.getDescription();
	}
	
}
