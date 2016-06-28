package com.serve.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serve.entity.Album;
import com.serve.entity.Consignee;
import com.serve.entity.OrderViewModel;
import com.serve.entity.Orderdetail;
import com.serve.entity.Orders;
import com.serve.service.AlbumService;
import com.serve.service.ConsigneeService;
import com.serve.service.OrderDetailService;
import com.serve.service.OrderService;
import com.serve.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderDetailService ords;
	
	@Autowired
	private AlbumService as;
	
	@Autowired
	private OrderService ors;
	
	@Autowired
	private ConsigneeService consigneeService;
	
	@Autowired
	private UserService userService;
	
	
	@InitBinder  
	  public void initBinder(WebDataBinder binder) {  
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	      dateFormat.setLenient(false);  
	      binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); 
	  }
	 
	@RequestMapping("/dobuy")
	public String dobuy(Orderdetail orderdetail,int id,String albumtitle,HttpServletRequest req){
		//获取当前用户未付款订单
		orderdetail.setOrder(ords.getCurrentOrderById(id));
		Orderdetail oldorderdetail = null;
		for(Orderdetail orde : ords.getCurrentOrderById(id).getOrderdetail()){
			if(orde.getAlbumId() == orderdetail.getAlbumId()){
				oldorderdetail = orde;
			}
		}
		if(oldorderdetail != null){
			int Quantity = oldorderdetail.getQuantity()+orderdetail.getQuantity();
			double unitPrice = Quantity*as.getAlbum(oldorderdetail.getAlbumId()).getPrice();
			oldorderdetail.setQuantity(Quantity);
			oldorderdetail.setUnitPrice(unitPrice);
			
			ords.updateOrderdetail(oldorderdetail);
		}
		else
			//增加商品
			ords.addOrderdetail(orderdetail);
		req.setAttribute("albumtitle", albumtitle);
		return "song-car-tip";
	}
	
	/*
	 * 购物车
	 * 获取订单详情+订单信息  填充到订单视图模型
	 */
	
	
	@RequestMapping("/gotocar")
	public String goToCar(int id,HttpServletRequest req){
		/*
		 * 将orderdetail表和album的信息重新包装成视图模型viewmodellist
		 */
		List<Orderdetail> orderlist = new ArrayList<Orderdetail>(ords.getCurrentOrderById(id).getOrderdetail());
		List<OrderViewModel> viewmodellist = new ArrayList<OrderViewModel>();
		
		//set转成list后是乱序，通过Collections.sort定义排序规则排序
		Collections.sort(orderlist,new Comparator<Orderdetail>(){  
            public int compare(Orderdetail arg0, Orderdetail arg1) {  
                return arg0.getId().compareTo(arg1.getId());  
            }  
        });
		double totalPrice = 0;
		int totalquantity = 0;
		
		//list的重新包装
		for(Orderdetail orde : orderlist){
						
			OrderViewModel viewmodel =new OrderViewModel();
			Album al = new Album();
			
			al=as.getAlbum(orde.getAlbumId());
			
			totalPrice += orde.getUnitPrice();
			totalquantity += orde.getQuantity();
			
			viewmodel.setId(orde.getId());
			viewmodel.setAlbumId(orde.getAlbumId());
			viewmodel.setUnitPrice(orde.getUnitPrice());
			viewmodel.setQuantity(orde.getQuantity());
			
			viewmodel.setAlbumName(al.getTitle());
			viewmodel.setArtist(al.getArtist());
			viewmodel.setPrice(al.getPrice());
			viewmodel.setPicPath(al.getPicPath());
			viewmodellist.add(viewmodel);
		}
		//将list返回给视图
		req.setAttribute("viewmodel", viewmodellist);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("totalquantity", totalquantity);
		return "song-car";
	}

	@RequestMapping("/deleteorder/{ordetdetailId}")
	public String deleteCarOrder(@PathVariable int ordetdetailId){		
		ords.deleteOrderdetail(ordetdetailId);
		return "redirect:/musicstore/order/gotocar?name=${name }";
	}
	
	@RequestMapping("/OrderConsignee/{totalquantity}/{totalPrice}/{username}")
	public String doCountOrder(@PathVariable String username,@PathVariable String totalquantity,@PathVariable String totalPrice,HttpServletRequest req){
		req.setAttribute("consigneelist", consigneeService.getConsigneeByUsername(username));
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("totalquantity", totalquantity);
		
		return "song-consignee";
	}
	
	/*
	 * 处理 填写订单详情+选择发货地址
	 * 根据consigneeid获取对应发货地址
	 * 填充订单生成时间
	 * 获取当前订单，更新订单信息
	 */
	@RequestMapping("/doOrderConsignee")
	public String doOrderConsignee(int userid,int consigneeid,Orders ord){
		
		Consignee consignee = consigneeService.getConsigneeById(consigneeid);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date d = new java.sql.Date(date.getTime());
		
		Orders temp = ords.getCurrentOrderById(userid);
		temp.setPayMethod(ord.getPayMethod());
		temp.setRemark(ord.getRemark());
		temp.setTotalpayment(ord.getTotalpayment());
		temp.setTotalquantity(ord.getTotalquantity());
		temp.setOrderDate(d);
		temp.setConsignee(consignee);
		ors.updateOrder(temp);/**/
		return "song-cashier";
	}
	
	/*
	 * 付款处理
	 * 将当前订单“isPay”字段置为1，表示已付款；
	 * 将“IsDeliveried”字段置为0，表示未发货；
	 * 生产新空白订单
	 */
	@RequestMapping("/dopay/{id}")
	public String doPay(@PathVariable int id){
		Orders order = ords.getCurrentOrderById(id);
		
		
		order.setIsPay(1);
		
		order.setIsDeliveried(0);
		
		ors.updateOrder(order);
		
		Orders newOrder = new Orders();
		java.util.Date date = new java.util.Date();
		java.sql.Date d = new java.sql.Date(date.getTime());
		
		newOrder.setUser(userService.getUserById(id));
		newOrder.setIsDeliveried(0);
		newOrder.setIsPay(0);
		newOrder.setPayMethod(0);
		newOrder.setTotalpayment(0.0);
		newOrder.setTotalquantity(0.0);
		newOrder.setOrderDate(d);
		ors.addOrder(newOrder);
		return "song-cashier-tip";
	}
}
