package com.serve.dao;

import java.util.List;

import com.serve.entity.Album;

public interface AlbumDao{
	
	public List<Album> getAlbumList();
	
	public Album getAlbum(int id);
		
	public List<Album> getAlbumsByGenreId(int id);
	
	public List<Album> getAlbumsByArtist(String srtist);
	
	public List<Album> getAlbumsByTitleKey(String titlekey);

	public boolean addAlbums(Album album);
	
	public boolean deleteAlbum(int id);
	
	public boolean updateAlbum(Album album);
}