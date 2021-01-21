package com.au.javacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
	
	@Bean(name="triangleObj")
	public Triangle getTriangle() {
		return new Triangle(1,2);
	}
	
	@Bean(name="p1obj")
	public Point getPoint1() {
		return new Point(0,0);
	}
	@Bean(name="p2obj")
	public Point getPoint2() {
		return new Point(0,20);
	}
	@Bean(name="p3obj")
	public Point getPoint3() {
		return new Point(10,0);
	}
	@Bean(name="p5obj")
	public Point getPoint4() {
		return new Point(10,20);
	}
	
}
