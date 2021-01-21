package com.au.javacode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")

public class Rectangle {
	@Autowired
	 @Qualifier("p1")
	private Point p1;
	
	@Autowired
	  @Qualifier("p2")
	private Point p2;
	
	@Autowired
	  @Qualifier("p3")
	private Point p3;
	
	@Autowired
	  @Qualifier("p4")
	private Point p4;
	
	public Rectangle(Point p1,Point p2,Point p3,Point p4) {
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		this.p4=p4;
	}
	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}
	public Point getP2() {
		return p1;
	}

	public void setP2(Point p1) {
		this.p1 = p1;
	}

	public Point getP3() {
		return p1;
	}

	public void setP3(Point p1) {
		this.p1 = p1;
	}

	public Point getP4() {
		return p1;
	}

	public void setP4(Point p1) {
		this.p1 = p1;
	}

	

	

}
