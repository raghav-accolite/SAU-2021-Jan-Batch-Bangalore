package com.accolite.assign.service;

import java.util.Random;




/*
 * 
 *DescisionServce class isused to give random decision 
 *getSelection() have parameter maxBound and returning random number in the range [0,maxBound]
 *getDecision() gives random Boolean value true or false
 * 
 * 
 */
public class DecisionServce {
	
	// random class object 
	static Random random = new Random();
	
	  // giving  random number
	   static public int getSelection(int maxBound) {
		   return random.nextInt(maxBound);
	   }
	   
	   // giving true and false randomly 
	   static public Boolean getDecision() {
		   return random.nextBoolean();
	   }
}
