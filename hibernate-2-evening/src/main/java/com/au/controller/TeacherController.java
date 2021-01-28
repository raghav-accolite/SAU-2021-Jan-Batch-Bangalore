package com.au.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.hibernate2evening.Repository.StudentRepository;
import com.au.hibernate2evening.Repository.TeacherRepository;
import com.au.hibernate2evening.entity.Student;
import com.au.hibernate2evening.entity.Teacher;

@RestController
public class TeacherController {
	@Autowired
	  TeacherRepository sr;
	   
	    public Optional<Teacher> findById(@RequestBody int id) {
	        return sr.findById(id);
	    }

}
