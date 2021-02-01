package com.accolite.assign.service;

import java.util.ArrayList;
import java.util.List;

import com.accolite.assign.model.Book;

/*
 * 
 * Bookervice class having getBookList() and showLogofBook() method 
 * 
 * getBookList() is used to give list of books i.e random created with upper limit 100
 * showLogofBook()  is used to print log that's of all the books 
 * 
 * log contain about book id corresponding to student id i.e checkout that book
 * 
 * 
 * 
 * 
 */




public class BookService {
     
	    // list of Book object
	    List<Book> bookList ;
	    
	    // object of DecisionService class 
		private DecisionServce decSer;
		
		// getBookList() method return list of Book object
	    public List<Book> getBookList(){
	    	
	    	// assigning object
	    	bookList = new ArrayList<>();
	    	
	    	// assigning object
	    	decSer = new DecisionServce();
	    	
	    	// geting rando number from getSelection() method of DecisionService class
	    	Integer numberOfBooks = decSer.getSelection(100);
	    	
	    	//random BookName,AuthorName,isbn number created to assign Book object 
	    	String  randomBookName = "";
	    	String  randomAuthorName = "";
	    	Integer randomisbnNumber = 1;
	    	
	    	// for loop adding book object to BookList
	    	for(Integer id = 0; id<numberOfBooks; id++) {
	    		
	    		// creating random values for the Book object field
	    		 randomBookName = "A" + id.toString();
	    		 randomAuthorName = "AN" + id.toString();
	    		 randomisbnNumber = id*10;
	    		 
	    		// add object to the list 
	    		bookList.add(new Book(randomBookName, randomAuthorName , id , randomisbnNumber , false));
	    	}
	    	
	    	
	  
	    	// returning book list;
	    	return bookList;
	    }
	    
	    
	    
	    // ShowLogoFBook() method  show about which book is checkout which student id 
	    public void showLogofBook() {
	    	bookList.forEach(book->{
	       System.out.print("Book id " + book.getId());
	    		if(book.getIsIssued()) {
	    		System.out.print("\t student id " +book.getStudentDetails().getId() + "\n");	
	    		
	    		
	    		}else {
	    			System.out.println(" \t Not issued yet");
	    		}
	    	
	    		
	    	});
	    }
	
}
