package com.javaconfig;

import org.springframework.stereotype.Component;


public class Company {

	private String cName;
	private String caddress;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getcName() {
		return cName;
	}



	public void setcName(String cName) {
		this.cName = cName;
	}



	public String getCaddress() {
		return caddress;
	}



	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}



	@Override
	public String toString() {
		return "Company [cName=" + cName + ", caddress=" + caddress + "]";
	}
	
	
	
}
