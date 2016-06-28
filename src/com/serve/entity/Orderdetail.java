package com.serve.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="orderdetail")
public class Orderdetail  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer Id;
	
	@Column
	private Double UnitPrice;
	
	@Column
	private Integer Quantity;	
	
	@Column
	private Integer AlbumId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OrderId")
	private Orders order;
	
	
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

	public Orderdetail() {
		
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	

}
