package com.au.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.hibernate2evening.Repository.StudentRepository;
import com.au.hibernate2evening.entity.Student;

@RestController
public class StudentController {
	 @Autowired
	  StudentRepository sr;
	   
	    public Optional<Student> findById(@RequestBody int id) {
	        return sr.findById(id);
	    }
}
