package com.serve.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity  
@Table(name="users")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2702918674046865911L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer  id;
	
	@Column(name="Username",length=50)
	private String username;
	
	@Column(name="Password",length=50)
	private String password;
	
	@Column(name="Name",length=50)
	private String nickname;
	
	@Column(name="Address",length=200)
	private String address;
	
	@Column(name="Phone",length=100)
	private String phone;
	
	@Column(name="Email",length=100)
	private String email;
	
	@Column(name="UserRoleId", nullable=false)
	private int userroleid;
	
	@Column(name="IsInUse",nullable=false)
	private int isinuse;
	
	@OneToMany(mappedBy="user")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Orders> order;
	
	
	public Integer  getId() {
		return id;
	}
	public void setId(Integer  id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(int userroleid) {
		this.userroleid = userroleid;
	}
	public int getIsinuse() {
		return isinuse;
	}
	public void setIsinuse(int isinuse) {
		this.isinuse = isinuse;
	}
	
	public Set<Orders> getOrder() {
		return order;
	}
	public void setOrder(Set<Orders> order) {
		this.order = order;
	}
	public User() {
	}
}
