package com.accolite.assign.main;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.accolite.assign.model.Book;
import com.accolite.assign.model.Student;
import com.accolite.assign.service.BookService;
import com.accolite.assign.service.StudentService;

 
/*
 * Main class is used to create libraryadmin thread for add book into Blocking queue
 * 
 * FixedsizedPool with size 5 and creating  thread of consumer class i.e student as identity 
 * and consuming Blocking Queue (abq)
 * 
 * 
 */

public class Library {
             
	public static void  main(String[] args) throws InterruptedException {
		
		System.out.println("Application runs ");
		 
		// BookService class object
		BookService bookser = new BookService();
		
		//StudentService class object
		StudentService studSer = new StudentService();
		
		// geting list of Book object 
		List<Book> bookList = bookser.getBookList();
		
		// getting list student object
		List<Student> studentList = studSer.getListofStudents();
		
		
		Integer numberOfBooks = bookList.size();
		
		
		// creating ArrayBlocking queue with size numberOfBooks 
		ArrayBlockingQueue<Book> abq = new ArrayBlockingQueue<Book>(numberOfBooks);
		
		
		// creating thread libaryAdmin ( Producer class ) and start 
		Thread libraryAdmin = new Thread(new Producer(abq,bookList));
		libraryAdmin.start();
		
		
		// creating Fixed sized pool with number of thread 5
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		
		// creating threads of consumer i.e student 
		try {
		studentList.forEach(student->{
			executor.execute(new Consumer(abq,student));
		});
		}catch(Exception e) {
			System.out.println("execption "+e);
		}finally{
			// shotdown executor
			executor.shutdown();
			
			// waiting for terminate all the threads
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			
		}
	
	        
        // is used to print size of abg queue to verify count 
		System.out.println("Size of abq "+abq.size());
		
		// print book logs 
		System.out.println("--------- Books Logs ----------");
		bookser.showLogofBook();
		
		// print student logs
		System.out.println("--------- Students Logs ----------");
		studSer.showLogsOfStudent();
		
		// taking time to terminate main thread then terminating here 
		System.exit(0);
	}
	
	
}

