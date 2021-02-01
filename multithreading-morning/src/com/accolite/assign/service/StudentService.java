package com.accolite.assign.service;

import java.util.ArrayList;
import java.util.List;

import com.accolite.assign.model.Student;



/*
 * 
 * StudentService class have method getListofStudents() and showLogsOfStudent()
 * 
 * getListofStudents() randomly creating student data and store into student list and return 
 * 
 */
public class StudentService {
	
	// Student object list
	private List<Student> studentList;

	// DecisionServce class object 
	private DecisionServce decSer;

	// returning list of 
	public List<Student> getListofStudents() {
		
		decSer = new DecisionServce();
		studentList = new ArrayList<>();
		
		// geting random number of studentts for create student object 
		Integer numberOfStudents = decSer.getSelection(100);
		
		// random name assign 
		String nameRandom ;
		
		// for is creating numberOfStudents of students object and adding to the studentList
		for (Integer id = 0; id < numberOfStudents; id++) {
			
			// creating random name to assign student object
			 nameRandom = "A" + id;
			studentList.add(new Student(nameRandom, id));
		}

		return studentList;
	}

	// show list of all students with student id and book id i.e checkout 
	// if no book checkout particular student then show no book checkout
	
	public void showLogsOfStudent() {
		studentList.forEach(student -> {
			System.out.print("Student id " + student.getId() + "\t Book id ");
			if (student.getCheckoutBook() != null) {
				System.out.print(student.getCheckoutBook().getId() + "\n");
			} else {
				System.out.println("No book Checkout \n");
			}
		});
	}
}
