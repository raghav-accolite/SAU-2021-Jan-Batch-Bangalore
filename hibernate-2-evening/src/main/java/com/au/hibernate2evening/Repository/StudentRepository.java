package com.au.hibernate2evening.Repository;

import org.springframework.data.repository.CrudRepository;

import com.au.hibernate2evening.entity.Student;


public interface StudentRepository extends CrudRepository<Student, Integer>{
	Student findbyId(int id);

}
