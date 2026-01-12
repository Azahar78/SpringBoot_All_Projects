package com.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my.db")
public class DbCon {

	//@Value("${my.db.name}")
	private String name;
	
	//@Value("${my.db.port}")
	private int port;
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPort() {
		return port;
	}



	public void setPort(int port) {
		this.port = port;
	}



	@Override
	public String toString() {
		return "DbCon [name=" + name + ", port=" + port + "]";
	}
	
	
}
