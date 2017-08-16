package com.stu.po;

public class User {
	private int id;
	private String uername;
	private String pasword;
	
	public User(int id, String uername, String pasword) {
		super();
		this.id = id;
		this.uername = uername;
		this.pasword = pasword;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUername() {
		return uername;
	}
	public void setUername(String uername) {
		this.uername = uername;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uername=" + uername + ", pasword="
				+ pasword + "]";
	}
	
}
