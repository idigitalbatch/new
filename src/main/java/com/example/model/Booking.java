package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")

public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cakeType;
	private String cakeKg;
	private String occassions;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(long id, String cakeType, String cakeKg, String occassions) {
		super();
		this.id = id;
		this.cakeType = cakeType;
		this.cakeKg = cakeKg;
		this.occassions = occassions;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCakeType() {
		return cakeType;
	}
	public void setCakeType(String cakeType) {
		this.cakeType = cakeType;
	}
	public String getCakeKg() {
		return cakeKg;
	}
	public void setCakeKg(String cakeKg) {
		this.cakeKg = cakeKg;
	}
	public String getOccassions() {
		return occassions;
	}
	public void setOccassions(String occassions) {
		this.occassions = occassions;
	}
	
	
	
}