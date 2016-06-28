package com.serve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serve.dao.GenreDao;
import com.serve.entity.Genre;
import com.serve.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService{
	
	@Autowired
	public GenreDao genreDao;

	@Override
	public boolean addGenre(Genre genre) {
		// TODO Auto-generated method stub
		return genreDao.addGenre(genre);
	}

	@Override
	public boolean deteleGenre(String name) {
		// TODO Auto-generated method stub
		return genreDao.deteleGenre(name);
	}

	@Override
	public List<Genre> getGenreList() {
		// TODO Auto-generated method stub
		return genreDao.getGenreList();
	}

	@Override
	public boolean update(Genre genre) {
		// TODO Auto-generated method stub
		return genreDao.update(genre);
	}

	@Override
	public String getDescriptionByName(String name) {
		// TODO Auto-generated method stub
		return genreDao.getDescriptionByName(name);
	}

}
