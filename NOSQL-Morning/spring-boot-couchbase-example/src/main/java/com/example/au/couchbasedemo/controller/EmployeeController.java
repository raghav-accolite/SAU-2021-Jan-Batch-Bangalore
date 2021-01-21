package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Blogs;
import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeerepository;
	
	@PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee newEmp) {
        return employeerepository.save(newEmp);
    }
    
    
    @GetMapping("/employee/{pincode}")
    public List<Employee> getEmployeeByPincode(@PathVariable String pincode) {
        return employeerepository.findAllByPincode(pincode);
    }
    @GetMapping("/employee/location/{location}")
    public List<Employee> findAllByLocation(@PathVariable String location){
    	Iterable<Employee> it = employeerepository.findAll();
    	List<Employee> list = new ArrayList<Employee>();
    	it.forEach(e ->{
    		if(e.getAddress().contains(location)) {
    			list.add(e);
    		}
    	});
    	return list;
    }
    
    


}
