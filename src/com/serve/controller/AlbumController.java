package com.serve.controller;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serve.entity.Album;
import com.serve.service.AlbumService;
import com.serve.service.GenreService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/album")
public class AlbumController {  
	@Autowired
	public AlbumService albumService;
	
	@Autowired
	public GenreService genreService;
	
	@RequestMapping("/getalbumlist")
	public String getAllAlbum(HttpServletRequest req,HttpSession session){
		
		req.setAttribute("albumlist", albumService.getAlbumList());
		session.setAttribute("genrelist", genreService.getGenreList());
		
		return "user-index";
	}
	
	
	
	@RequestMapping("/albumdesc/{id}")
	public String albumdesc(@PathVariable int id ,HttpServletRequest req){
		req.setAttribute("album", albumService.getAlbum(id));
		return "song-desc";
	}
	
	@RequestMapping("/addtocar/{id}")
	public String addtocar(@PathVariable int id,HttpServletRequest req){
		req.setAttribute("album", albumService.getAlbum(id));
		System.out.println(id);
		return "song-car-tip";
	}
	
	@RequestMapping("/gotocar")
	public String gotocar(){
		return "song-car";
	}
	
	@RequestMapping("/search")
	public String search(String key ,HttpServletRequest req){
		req.setAttribute("albumlist", albumService.getAlbumByKey(key));		
		return "user-index";
	}
	
	@RequestMapping("/getalbumlistbygenre/{genreid}")
	public String getAlbumListByGenre(@PathVariable int genreid,HttpServletRequest req){
		req.setAttribute("albumlist", albumService.getAlbumByGenreID(genreid));
		return "user-index";
	}
}
