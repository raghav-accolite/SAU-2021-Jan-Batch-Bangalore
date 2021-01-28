package com.au.hibernate2evening.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(name = "name")
	    private String name;

	    @ManyToMany(mappedBy = "student", cascade = CascadeType.ALL)
	    Set<Teacher> teacher;


}
