package com.au.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.*;

public class DrawingApp {
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
		AbstractApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		factory.registerShutdownHook();
		DrawingApp da = (DrawingApp)factory.getBean("mapset");
		da.display();
		//t.draw();
		/*AbstractApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml"); 	      
		factory.registerShutdownHook();
		Triangle triangle = (Triangle)factory.getBean("triangle");//bean id
		triangle.draw();*/
		
		
	}

}
