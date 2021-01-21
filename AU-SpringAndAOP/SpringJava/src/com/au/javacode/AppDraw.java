package com.au.javacode;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppDraw {
	public static void main(String[] args) throws IOException {
		
		//ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml"); 
		
		//when using AppConfig.class
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Triangle triangle = (Triangle)factory.getBean("triangleObj");
		
		triangle.draw();
//		
	}

}
