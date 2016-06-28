package com.serve.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.serve.dao.*;
import com.serve.entity.Album;
	
@Transactional
@Repository
public class AlbumDaoImpl implements AlbumDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Album> getAlbumList() {
		
		String hql = "from Album";
		Session ss = sessionFactory.getCurrentSession();
		Query query = ss.createQuery(hql);	
		return query.list();
	}

	@Override
	public Album getAlbum(int id) {
		
		String hql = "from Album a where a.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, Integer.toString(id));
		
		return (Album)query.uniqueResult();
	}

	@Override
	public List<Album> getAlbumsByGenreId(int id) {
		
		String hql = "from Album a where a.genreid = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, Integer.toString(id));
		
		return query.list();
		
	}

	@Override
	public List<Album> getAlbumsByArtist(String srtist) {

		String hql = "from Album a where a.artist = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, srtist);
		
		return query.list();
	}

	@Override
	public List<Album> getAlbumsByTitleKey(String titlekey) {

		String hql = "from Album a where a.title like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+titlekey+"%");
		
		return query.list();
	}

	@Override
	public boolean addAlbums(Album album) {
		
		int i = (Integer)sessionFactory.getCurrentSession().save(album);
		if(i > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteAlbum(int id) {
		
		String hql = "delete Album a where a.id= ?";		
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, Integer.toString(id));
		
		return (q.executeUpdate() > 0);
	}

	@Override
	public boolean updateAlbum(Album album) {
		
		String hql = "update Album a set a.artist=?,a.dateReleased=?,a.description=?,a.genreid=?,a.picPath=?,a.price=?,a.title=? where a.id=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, album.getArtist());
		q.setDate(1, album.getDateReleased());
		q.setString(2, album.getDescription());
		q.setInteger(3, album.getGenreid());
		q.setString(4, album.getPicPath());
		q.setDouble(5, album.getPrice());
		q.setString(6, album.getTitle());
		q.setInteger(7, album.getId());
		
		return (q.executeUpdate() > 0);
	}

}

