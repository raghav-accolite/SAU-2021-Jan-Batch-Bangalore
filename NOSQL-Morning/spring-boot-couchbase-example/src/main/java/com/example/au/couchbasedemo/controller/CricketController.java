package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.example.au.couchbasedemo.model.Cricket;
import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.CricketRepository;

@RestController
public class CricketController {
	@Autowired
	CricketRepository cricketRepository;
	
	@PostMapping("/cricket")
    public Cricket addCricket(@RequestBody Cricket newCric) {
        return cricketRepository.save(newCric);
    }
  
    
    @GetMapping("/cricket/{run}")
    public List<Cricket> getAllGreaterThan(@PathVariable String run) {
    	int intrun;
    	List<Cricket> list = new ArrayList<Cricket>();
    	try {
    		intrun=Integer.parseInt(run);  
    		Iterable<Cricket> it = cricketRepository.findAll();
    		
    		it.forEach(e -> {
    			if(e.getRun() > intrun) {
    				list.add(e);
    			}
    		});
    		
    		return list;
    	}
    	catch(Exception e) {
    		return list;
    	}
 
        
    }
   
    


}
