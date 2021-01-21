package com.au.javacode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Triangle {
	@Autowired
	 @Qualifier("height")
	private int height;
	@Autowired
	  @Qualifier("widhth")
	private int width;
	
	
	public Triangle(int a,int b) {
		this.height=a;
		this.width=b;
	}
	public void setHeight(int height) {
		this.height=height;
	}
	public int getHeight() {
		return this.height;
	}
	public int getWidth() {
		return this.width;
	}
	public void setWidth(int width) {
		this.width=width;
	}
	public void draw() {
		  System.out.println(" Triangle Drawn of height"+getHeight()+"with width"+getWidth());
		  }

}
