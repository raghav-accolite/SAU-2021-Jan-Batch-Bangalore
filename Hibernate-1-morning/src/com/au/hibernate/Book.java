package com.au.hibernate;

public class Book {
	private int id;
	private String name;
	private String language;
	private int publishYear;
	public Book() {
		this.name="Default";
		this.language="Default";
		this.publishYear=0;
		
	}

	public Book(String name, String language, int publishYear) {
		this.setName(name);
		this.setLanguage(language);
		this.setPublishYear(publishYear);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

}
