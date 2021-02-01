package com.accolite.assign.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/*
 * Student class have name , id and checkoutBook ( Book object )
 * queueCart is used to add book for review with maximum 10 books 
 * addBooktocart(Book selectedbook) is used to add book into queuecart
 * 
 */
public class Student {

	private String name;
	private Integer id;

	private Book checkoutBook;

	private ArrayBlockingQueue<Book> queueCart;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void addBooktocart(Book selectedbook) {
		this.queueCart.add(selectedbook);
	}

	public Book getCheckoutBook() {
		return checkoutBook;
	}

	public void setCheckoutBook(Book checkoutBook) {
		this.checkoutBook = checkoutBook;
	}

	public ArrayBlockingQueue<Book> getQueueCart() {
		return queueCart;
	}

	public void setQueueCart(ArrayBlockingQueue<Book> queueCart) {
		this.queueCart = queueCart;
	}

	public Student(String name, Integer id) {

		this.name = name;
		this.id = id;

		this.queueCart = new ArrayBlockingQueue<Book>(10);
	}

	public Student() {

	}

}
