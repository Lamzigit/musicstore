package com.serve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serve.dao.AlbumDao;
import com.serve.entity.Album;
import com.serve.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService{
	
	@Autowired
	public AlbumDao albumDao;
	
	@Override
	public List<Album> getAlbumList() {
		
		return albumDao.getAlbumList();
	}

	@Override
	public Album getAlbum(int id) {
		
		return albumDao.getAlbum(id);
	}

	@Override
	public List<Album> getAlbumByGenreID(int genreId) {
		// TODO Auto-generated method stub
		return albumDao.getAlbumsByGenreId(genreId);
	}

	@Override
	public List<Album> getAlbumByKey(String key) {
		// TODO Auto-generated method stub
		return albumDao.getAlbumsByTitleKey(key);
	}

	@Override
	public boolean addAlbums(Album album) {
		// TODO Auto-generated method stub
		return albumDao.addAlbums(album);
	}

	@Override
	public boolean deleteAlbums(int id) {
		// TODO Auto-generated method stub
		return albumDao.deleteAlbum(id);
	}

	@Override
	public boolean updataeAlbums(Album album) {
		// TODO Auto-generated method stub
		return albumDao.updateAlbum(album);
	}
	
}
