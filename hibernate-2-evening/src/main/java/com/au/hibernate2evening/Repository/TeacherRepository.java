package com.au.hibernate2evening.Repository;

import org.springframework.data.repository.CrudRepository;

import com.au.hibernate2evening.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{
	Teacher findbyId(int id);

}
