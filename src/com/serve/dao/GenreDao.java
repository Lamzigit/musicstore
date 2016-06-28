package com.serve.dao;

import java.util.List;
import com.serve.entity.Genre;

public interface GenreDao {
	
	public boolean addGenre(Genre genre);
	
	public boolean deteleGenre(String name);
	
	public List<Genre> getGenreList();
	
	public boolean update(Genre genre);
	
	public String getDescriptionByName(String name);
}
