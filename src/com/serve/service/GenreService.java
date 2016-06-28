package com.serve.service;

import java.util.List;

import com.serve.entity.Genre;

public interface GenreService {
	
	public boolean addGenre(Genre genre);
	
	public boolean deteleGenre(String name);
	
	public List<Genre> getGenreList();
	
	public boolean update(Genre genre);
	
	public String getDescriptionByName(String name);
}
