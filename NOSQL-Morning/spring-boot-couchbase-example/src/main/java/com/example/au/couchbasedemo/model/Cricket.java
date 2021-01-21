package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Cricket {
	
	@Id
	private String cricketorId;
	
	@NotNull
	@Field
	private String name;
	
	@NotNull
	@Field
	private int average;
	
	@NotNull
	@Field
	private int run;

	
	public Cricket(String cricketorId, String name, int average,int run) {
		super();
		this.cricketorId = cricketorId;
		this.name = name;
		this.average = average;
		this.run = run;
		
	}

	public String getCricketorId() {
		return cricketorId;
	}

	public void setCricketorId(String CricketorId) {
		this.cricketorId = CricketorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}
	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}
	
	

}
