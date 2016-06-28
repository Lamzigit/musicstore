package com.serve.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="orders")
public class Orders  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8977989966053661622L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;
	
	@Column
	private Date OrderDate;
	
	@Column
	private Integer payMethod;
	
	@Column
	private Double totalpayment;
	
	@Column	
	private Double totalquantity;
	
	@Column	
	private Integer isPay;
	
	@Column
	private Integer IsDeliveried;

	@Column(length=80)
	private String remark;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="consigneeid")
	private Consignee consignee;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order") 
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Orderdetail> orderdetail;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Double getTotalpayment() {
		return totalpayment;
	}

	public void setTotalpayment(Double totalpayment) {
		this.totalpayment = totalpayment;
	}

	public Double getTotalquantity() {
		return totalquantity;
	}

	public void setTotalquantity(Double totalquantity) {
		this.totalquantity = totalquantity;
	}

	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Integer getIsDeliveried() {
		return IsDeliveried;
	}

	public void setIsDeliveried(Integer isDeliveried) {
		IsDeliveried = isDeliveried;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<Orderdetail> getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(Set<Orderdetail> orderdetail) {
		this.orderdetail = orderdetail;
	}
	
	public Consignee getConsignee() {
		return consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	public Orders() {
		
	}
	
	
}
