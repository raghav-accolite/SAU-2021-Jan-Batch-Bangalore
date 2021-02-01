package com.accolite.assign.main;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import com.accolite.assign.model.Book;


/*
 * Producer class is used to add book into abq (ArrayBlockingQueue )
 * 
 * 
 */
public class Producer implements Runnable{

	 private ArrayBlockingQueue<Book> abq;
	 private List<Book> bookList;
	 
	  public Producer(ArrayBlockingQueue<Book> abq, List<Book> bookList) {
		  this.abq = abq;
		  this.bookList = bookList;
	  }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		   
		  // adding book to the  abq blocking queue
		   for(int i=0;i<bookList.size();i++) {
			   abq.add(bookList.get(i));
		   }
		  
	}

}
