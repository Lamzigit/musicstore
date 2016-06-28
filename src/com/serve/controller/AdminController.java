package com.serve.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.List;


import java.io.OutputStream;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.serve.entity.Album;
import com.serve.entity.Consignee;
import com.serve.entity.Genre;
import com.serve.entity.OrderViewModel;
import com.serve.entity.Orderdetail;
import com.serve.entity.Orders;
import com.serve.service.AlbumService;
import com.serve.service.ConsigneeService;
import com.serve.service.GenreService;
import com.serve.service.OrderDetailService;
import com.serve.service.OrderService;
import com.serve.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ConsigneeService consigneeService;
	
	@Autowired
	private GenreService genreService;
	
	
	@RequestMapping("/albumlist")
	public String adminIndex(HttpServletRequest req ){
		req.setAttribute("albumlist", albumService.getAlbumList());
		
		return "admin-index";
	}
	
	@RequestMapping("/dodelete")
	@ResponseBody
	public void dodelete(int albumid,HttpServletResponse resp) throws IOException{
		if(albumService.deleteAlbums(albumid)){
			resp.getWriter().print("true");
		}
		else
			resp.getWriter().print("false");
		
	}
	
	@RequestMapping("/addsong")
	public String addsong(HttpServletRequest req){
		req.setAttribute("genrelist", genreService.getGenreList());
		return "admin-addsong";
	}
	
	@InitBinder  
	  public void initBinder(WebDataBinder binder) {  
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	      dateFormat.setLenient(false);  
	      binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); 
	  }
	
	@RequestMapping("/doaddsong")
	public String doAddSong(Album album ,@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
		//获取上传文件名
		//file.getOriginalFilename()
		//获取上传文件路径
		String path = request.getRealPath("/img");
		InputStream is = file.getInputStream();
		
		OutputStream os = new FileOutputStream(new File(path,file.getOriginalFilename()));
		int len = 0;
		byte[] buffer = new byte[400];
		while((len=is.read(buffer))!= -1)
			os.write(buffer, 0, len);
		os.close();
		is.close();
		album.setPicPath("/musicstore/img/"+file.getOriginalFilename());
		albumService.addAlbums(album);
		return "redirect:/admin/albumlist";
	}
	
	@RequestMapping("/editalbum/{albumid}")
	public String editAlbum(@PathVariable int albumid,HttpServletRequest request){
		request.setAttribute("genrelist", genreService.getGenreList());
		request.setAttribute("album", albumService.getAlbum(albumid));
		return "admin-album-edit";
	}
	
	@RequestMapping("/doeditsong")
	public String doEditAlbum(Album album ,@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
		//获取上传文件名
		//file.getOriginalFilename()
		//获取上传文件路径
		if(file.getOriginalFilename()!= ""){
			String path = request.getRealPath("/img");
			InputStream is = file.getInputStream();
			
			OutputStream os = new FileOutputStream(new File(path,file.getOriginalFilename()));
			int len = 0;
			byte[] buffer = new byte[400];
			while((len=is.read(buffer))!= -1)
				os.write(buffer, 0, len);
			os.close();
			is.close();
			album.setPicPath("/musicstore/img/"+file.getOriginalFilename());
		}
		System.out.println("--------------------------------------------------"+album.getGenreid()+"--------------------------------------------------"+album.getId());
		albumService.updataeAlbums(album);
		
		return "redirect:/admin/albumlist";
	}
	
	@RequestMapping("/userlist")
	public String userList(HttpServletRequest req){
		req.setAttribute("userlist", userService.getAllUser());
		return "admin-user-list";
	}
	
	@RequestMapping("/getuserorderlist/{userid}")
	public String getUserOrderList(@PathVariable int userid,HttpServletRequest req){
		
		
		req.setAttribute("userorderlist", orderService.getOrderListById(userid));
		return "admin-userorder-list";
	}
	
	@RequestMapping("/getdeliveriedorderlist")
	public String getDeliveriedOrderList(HttpServletRequest req){
		req.setAttribute("userorderlist", orderService.getDeliveriedOrderList());
		return "admin-userorder-list";
	}
	
	@RequestMapping("/getnotdeliveryorderlist")
	public String getNotDeliveryOrderList(HttpServletRequest req){
		req.setAttribute("userorderlist", orderService.getNotDeliveryOrderList());
		return "admin-userorder-list";
	}
	
	@RequestMapping("/getconsigneelist")
	public String getConsigneeList(HttpServletRequest req){
		req.setAttribute("consigneelist", consigneeService.getConsigneeList()  );
		return "admin-consignee-list";
	}
	
	@RequestMapping("/dodelivery/{orderid}")
	public String doDelivery(@PathVariable int orderid){
		Orders order = orderService.getOrderById(orderid);
		order.setIsDeliveried(1);
		orderService.updateOrder(order);
		return "redirect:/admin/getnotdeliveryorderlist";
	}
	
	@RequestMapping("/getconsigneedesc/{id}")
	public String getConsigneeDesc( @PathVariable int id,HttpServletRequest req){
		/*
		 * 将orderdetail表和album的信息重新包装成视图模型viewmodellist
		 */
		Orders order = orderService.getOrderById(id);
		Consignee consignee = order.getConsignee();
		List<Orderdetail> orderlist = new ArrayList<Orderdetail>(order.getOrderdetail());
		List<OrderViewModel> viewmodellist = new ArrayList<OrderViewModel>();
		
		//set转成list后是乱序，通过Collections.sort定义排序规则排序
		Collections.sort(orderlist,new Comparator<Orderdetail>(){  
            public int compare(Orderdetail arg0, Orderdetail arg1) {  
                return arg0.getId().compareTo(arg1.getId());  
            }  
        });
		
		//list的重新包装
		for(Orderdetail orde : orderlist){
						
			OrderViewModel viewmodel =new OrderViewModel();
			Album al = new Album();
			
			al=albumService.getAlbum(orde.getAlbumId());
			
			viewmodel.setId(orde.getId());
			viewmodel.setAlbumId(orde.getAlbumId());
			viewmodel.setAlbumName(albumService.getAlbum(orde.getAlbumId()).getTitle());
			viewmodel.setUnitPrice(orde.getUnitPrice());
			viewmodel.setQuantity(orde.getQuantity());
			viewmodel.setAlbumName(al.getTitle());
			viewmodel.setArtist(al.getArtist());
			viewmodel.setPrice(al.getPrice());
			viewmodel.setPicPath(al.getPicPath());
			viewmodellist.add(viewmodel);
		}
		
		//将list返回给视图
		req.setAttribute("consignee", consignee);
		req.setAttribute("orderdesclist", viewmodellist);
		
		return "admin-order-desc";
	}
	
	@RequestMapping("/genrelist")
	public String genreList(HttpServletRequest req){
		req.setAttribute("genrelist", genreService.getGenreList());
		return "admin-genrelist";
	}	
	
	@ResponseBody 
	@RequestMapping("/addgenre")
	public void ajaxAddGenre(Genre genre,HttpServletResponse res) throws IOException{
		if(genreService.addGenre(genre)){
			 res.getWriter().write("成功");
		}
		else{
			res.getWriter().write("fail");
		}
	}
}
