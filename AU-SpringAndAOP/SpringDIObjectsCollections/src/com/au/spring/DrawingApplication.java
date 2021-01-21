package com.au.spring;


import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApplication {
	public Map<String,String> map;
	public Set<String> set;
	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public void display() {
		System.out.println("Set Contains");
		set.forEach(e-> System.out.println(e));
		System.out.println("Map Contains");
		Set<String> keys = map.keySet();
		keys.forEach(e-> System.out.println(e+" -> "+map.get(e)));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Triangle t = new Triangle();
		ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		DrawingApplication da = (DrawingApplication)factory.getBean("mapset");
		da.display();
		//t.draw();
		
		
	}

}
