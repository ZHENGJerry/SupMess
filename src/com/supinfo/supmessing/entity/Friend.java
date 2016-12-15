package com.supinfo.supmessing.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="friend")
public class Friend implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstuser;
	private String seconduser;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstuser() {
		return firstuser;
	}
	public void setFirstuser(String firstuser) {
		this.firstuser = firstuser;
	}
	public String getSeconduser() {
		return seconduser;
	}
	public void setSeconduser(String seconduser) {
		this.seconduser = seconduser;
	}

	
}
