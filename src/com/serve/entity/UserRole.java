package com.serve.entity;

import java.io.Serializable;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="userrole")
public class UserRole  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9127554027278795006L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer Id;
	
	@Column(length=50)
	public String Name;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public UserRole() {

	}
	
	
}
