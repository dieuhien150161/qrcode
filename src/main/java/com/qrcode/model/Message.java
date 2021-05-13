package com.qrcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	private String hoten;
	private String email;
	
	@Type(type = "text")
	private String tinnhan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTinnhan() {
		return tinnhan;
	}
	public void setTinnhan(String tinnhan) {
		this.tinnhan = tinnhan;
	}
	public Message(String hoten, String email, String tinnhan) {
		super();
		this.hoten = hoten;
		this.email = email;
		this.tinnhan = tinnhan;
	}
	
	public Message() {
		
	}
	
}
