package com.entity;

public class Register {
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String uname,PhNo,email,password;
	
	public Register() {
		super();
	}
	public Register(String uname, String PhNo, String email, String password) {
		super();
		this.uname = uname;
		this.PhNo = PhNo;
		this.email = email;
		this.password = password;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhNo() {
		return PhNo;
	}
	public void setPhoneno(String PhNo) {
		this.PhNo = PhNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
