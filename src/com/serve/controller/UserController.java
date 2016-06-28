package com.serve.controller;

import java.io.IOException;  
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serve.entity.Album;
import com.serve.entity.Consignee;
import com.serve.entity.OrderViewModel;
import com.serve.entity.Orderdetail;
import com.serve.entity.Orders;
import com.serve.entity.User;
import com.serve.service.AlbumService;
import com.serve.service.ConsigneeService;
import com.serve.service.OrderDetailService;
import com.serve.service.OrderService;
import com.serve.service.UserService;  


@Controller 
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private ConsigneeService consigneeService;
	
	@Autowired
	private OrderService ors;
	
	@Autowired
	private OrderDetailService orderdetailService;
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping("/login")
	public String userlogin(){
		return "user-login";
	}
	
	@RequestMapping("/dologin")
	public String dologin(String username,String password,HttpSession s){
		User user = userService.getUserByUsername(username);
		if(user != null&&password.equals(user.getPassword())){
			s.setAttribute("name", user.getUsername());
			s.setAttribute("userid", user.getId());
			return "redirect:/album/getalbumlist";
		}	
		return "redirect:/user/login";
	}
	
	@RequestMapping("/register")
	public String userregister(){
		return "user-register";
	}
	
	@RequestMapping("/doregister")
	public String doUserLogin(User user,HttpSession s){
		if(user!=null && userService.addUser(user)){
			//从新获取user对象，id字段才有值
			user = userService.getUserByUsername(user.getUsername());
			
			s.setAttribute("name", user.getUsername());
			s.setAttribute("userid", user.getId());
			Orders newOrder = new Orders();
			java.util.Date date = new java.util.Date();
			java.sql.Date d = new java.sql.Date(date.getTime());
			
			newOrder.setUser(user);
			newOrder.setIsDeliveried(0);
			newOrder.setIsPay(0);
			newOrder.setPayMethod(0);
			newOrder.setTotalpayment(0.0);
			newOrder.setTotalquantity(0.0);
			newOrder.setOrderDate(d);
			ors.addOrder(newOrder);
			return "redirect:/album/getalbumlist";
		}		
		return "user-register";
	}
	
	@RequestMapping("/dologout ")
	public String dologout(HttpSession s){
		s.removeAttribute("name");
		return "redirect:/album/getalbumlist";
	}
	
	@RequestMapping("/getAllUser")  
    public String getAllUser(HttpServletRequest request){  
          
        request.setAttribute("userList", userService.getAllUser());  
          
        return "/index";  
    }  
      
    @RequestMapping("/getUser")  
    public String getUser(int id,HttpServletRequest request){  
          
        request.setAttribute("user", userService.getUserById(id));  
      
        return "/editUser";  
    }  
      
    @RequestMapping("/toAddUser")  
    public String toAddUser(){  
        return "/addUser";  
    }  
      
    @RequestMapping("/addUser")  
    public String addUser(User user,HttpServletRequest request){  
          
        userService.addUser(user);  
          
        return "redirect:/user/getAllUser";  
    }  
      
    @RequestMapping("/delUser")  
    public void delUser(String id,HttpServletResponse response){  
          
        String result = "{\"result\":\"error\"}";  
          
        if(userService.delUser(id)){  
            result = "{\"result\":\"success\"}";  
        }  
          
        response.setContentType("application/json");  
          
        try {  
            PrintWriter out = response.getWriter();  
            out.write(result);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    @RequestMapping("/updateUser")  
    public String updateUser(User user,HttpServletRequest request){  
          
        if(userService.updateUser(user)){  
            user = userService.getUserById(user.getId());  
            request.setAttribute("user", user);  
            return "redirect:/user/getAllUser";  
        }else{  
            return "/error";  
        }  
    } 
    
    @RequestMapping("/getuserdesc/{id}")
    public String getUserDesc(@PathVariable int id,HttpServletRequest req){
    	
    	//获取用户
    	User user = userService.getUserById(id);
    	//获取用户地址列表
    	List<Consignee> consignee = consigneeService.getConsigneeByUsername(user.getUsername());
    	//获取用户订单列表
    	List<Orders> orders = new ArrayList<Orders>(user.getOrder());   	
    	//set转成list后是乱序，通过Collections.sort定义排序规则排序
		Collections.sort(orders,new Comparator<Orders>(){  
            public int compare(Orders arg0, Orders arg1) {  
                return arg0.getId().compareTo(arg1.getId());  
            }  
        });
    	
    	List<Orderdetail> orderlist = new ArrayList<Orderdetail>(orderdetailService.getCurrentOrderById(user.getId()).getOrderdetail());
		List<OrderViewModel> viewmodellist = new ArrayList<OrderViewModel>();
		
		
		double totalPrice = 0;
		int totalquantity = 0;
		
		//list的重新包装
		for(Orderdetail orde : orderlist){
						
			OrderViewModel viewmodel =new OrderViewModel();
			Album al = new Album();
			
			al=albumService.getAlbum(orde.getAlbumId());
			
			totalPrice += orde.getUnitPrice();
			totalquantity += orde.getQuantity();
			
			viewmodel.setId(orde.getId());
			viewmodel.setAlbumId(orde.getAlbumId());
			viewmodel.setUnitPrice(orde.getUnitPrice());
			viewmodel.setQuantity(orde.getQuantity());
			
			viewmodel.setAlbumName(al.getTitle());
			viewmodel.setArtist(al.getArtist());
			viewmodel.setPrice(al.getPrice());
			viewmodellist.add(viewmodel);
		}
		//将list返回给视图
		req.setAttribute("viewmodel", viewmodellist);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("totalquantity", totalquantity);
    	
    	req.setAttribute("user", user);
    	req.setAttribute("consigneelist", consignee);
    	req.setAttribute("userorderlist", orders);
    	
    	return "user-desc";
    }
    
    @RequestMapping("/getconsigneedesc/{id}")
	public String getConsigneeDesc( @PathVariable int id,HttpServletRequest req){
		/*
		 * 将orderdetail表和album的信息重新包装成视图模型viewmodellist
		 */
		Orders order = ors.getOrderById(id);
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
			viewmodellist.add(viewmodel);
		}
		
		//将list返回给视图
		req.setAttribute("consignee", consignee);
		req.setAttribute("orderdesclist", viewmodellist);
		
		return "user-order-desc";
	}
    
    @RequestMapping("/userinfomodify/{username}")
    public String usreInfoModify(@PathVariable String username,HttpServletRequest req){
    	User user = userService.getUserByUsername(username);
    	req.setAttribute("user", user);
    	return "user-info-modify";
    }
    
    @RequestMapping("/douserinfomodify/{id}")
    public String doUsreInfoModify(User user,HttpSession session){
    	
    	userService.updateUser(user);
    	session.removeAttribute("name");
    	session.setAttribute("name", user.getUsername());
    	return "redirect:/user/getuserdesc/"+user.getUsername().toString();
    }
    
    @RequestMapping("/addconsignee")
    public String addConsignee(){
    	return "user-add-consignee";
    }
    
    @RequestMapping("/doaddconsignee")
    public String doAddConsignee(Consignee consignee){
    	consigneeService.addConsignee(consignee);   	
    	return "redirect:/user/getuserdesc/" + consignee.getUsername();
    }
} 
