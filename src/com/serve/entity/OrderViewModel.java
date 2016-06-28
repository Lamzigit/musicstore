package com.serve.entity;

public class OrderViewModel {
		
	private Integer Id;
		
	private Double UnitPrice;
		
	private Integer Quantity;	
		
	private Integer AlbumId;
	
	private String Artist;

	private Orders order;
	
	private String AlbumName;
	
	private Double Price;
	
	private String picPath;
	
	
	public String getAlbumName() {
		return AlbumName;
	}

	public void setAlbumName(String albumName) {
		AlbumName = albumName;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		UnitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}	

	public Integer getAlbumId() {
		return AlbumId;
	}

	public void setAlbumId(Integer albumId) {
		AlbumId = albumId;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}
	
	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public OrderViewModel() {
		
		// TODO Auto-generated constructor stub
	}
	
	
}
