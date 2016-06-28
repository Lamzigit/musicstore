package com.serve.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.serve.entity.Album;

public interface AlbumService {
	//��ѯ��Ƭ
	public List<Album> getAlbumList();
	
	//��ѯ���ų�Ƭ
	public Album getAlbum(int id);
	
	//��ݳ�Ƭ�����ѯ����
	public List<Album> getAlbumByGenreID(int genreId);
	
	//��ݹؼ���ģ���ѯ
	public List<Album> getAlbumByKey(String key);
	
	//���ӳ�Ƭ
	public boolean addAlbums(Album album);
	
	//ɾ��Ƭ
	public boolean deleteAlbums(int id);
	
	//�޸ĳ�Ƭ
	public boolean updataeAlbums(Album album);
	
}
