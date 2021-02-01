package com.accolite.assign.model;




/*
 * 
 * Book class have property name,authorName,isbnNo,id,isIssued,ischekout,startTimer,limitTimer,Student object
 * 
 * startTimer() is used to assign current tie to startTimer variable
 * 
 * resetTimer() is used to assign 0 to startTimer property
 * 
 * checkTimerEnds is gives true if limit of book time exceed or false if not
 * 
 * and getters and setters 
 * 
 */
public class Book {
	
     private String name;
     private String authorName;
     private Integer isbnNo;
     private Integer id;
     private volatile Boolean isIssued;
     private volatile Boolean ischeckOut;

	 private long startTimer;
	 
	final  private long limitTimer = 300000;
	 
	 private Student student;
	 
	 
	public Book(String name, String authorName, Integer isbnNo,Integer id, Boolean isIssued) {
		this.name = name;
		this.authorName = authorName;
		this.isbnNo = isbnNo;
		this.id = id;
		this.isIssued = isIssued;
		this.ischeckOut = isIssued;
		this.startTimer = 0;
	}
     
     public Book() {}

     
     // startTimer() is used to assign current time in milliseconds when book add into student cart 
     public void startTimer() {
    	 startTimer = System.currentTimeMillis();
     }
     
     // resetTimer() is used to set startTimer to again 0 when book checkout or remove from student cart 
     public void resetTimer() {
    	 startTimer = 0;
     }
     
     //checkTimerEnds() check limit in student cart
     public Boolean checkTimerEnds(long currentTimer) {
    	 if((startTimer + limitTimer)<currentTimer)
    		 return true;
    	 else return false;
     }
     
     // addStudentDetials() is used to assign student details i.e checkout book  
     public void addStudentDetails(Student student) {
    	 this.student = student;
     }
     
     public Student getStudentDetails() {
    	 return student;
     }
     
     
     
     
	public Boolean getIscheckOut() {
		return ischeckOut;
	}

	public void setIscheckOut(Boolean ischeckOut) {
		this.ischeckOut = ischeckOut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getIsbnNo() {
		return isbnNo;
	}

	public void setIsbnNo(Integer isbnNo) {
		this.isbnNo = isbnNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsIssued() {
		return isIssued;
	}

	public void setIsIssued(Boolean isIssued) {
		this.isIssued = isIssued;
	}
     
     
     
     
     
}


