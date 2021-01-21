package com.au.aop.aspect;

import org.aspectj.lang.annotation.*;


//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	
	//to write specifically for circle class write om.au.aop.model.Circle.getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
	@Around("execution(public * setName(..))")
	public void AroundAdvice() { 
		System.out.println("Around Advice");
	}
	
	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Logging Advice");
		
	}

	@AfterReturning("execution(public * get*(..))")
	public void afterReturnAdvice() {
		System.out.println("After Advice");
		
	}
	
	@After("execution(public * get*(..))")
	public void afterAdvice() {
		System.out.println("After Advice");
		
	}
	

	@AfterThrowing("execution(public * get*(..))")
	public void AfterThrowingAdvice() { 
		System.out.println("After Throwing Advice");
	}


}
