package com.accolite.assign.main;

import java.util.Iterator;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

import com.accolite.assign.model.Book;
import com.accolite.assign.model.Student;

/*
 * TimerCheck class is used to check time limit of those book in student cart 
 * if timeLimit exceed then remove from student cart to again abq ( ArrayBlockingQueue)
 * 
 */
public class TimerCheck extends TimerTask {
	
	 
	ArrayBlockingQueue<Book> abq;
	Student student;

	public TimerCheck(ArrayBlockingQueue<Book> abq, Student student) {
		this.abq = abq;
		this.student = student;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// System.out.println(" ***************cart size of "
		// +student.getQueueCart().size());

		// Iterator of the student cart 
		Iterator<Book> it = student.getQueueCart().iterator();
		
		// while loop iterarting to the student cart 
		while (it.hasNext()) {

			Book book = it.next();
			
			// if timelimit exceed then remove book from student cart 
			if (book.checkTimerEnds(System.currentTimeMillis())) {

				System.out.println("Removing book from student id " + student.getName() + "book id " + book.getId());

				// setIssued again false
				book.setIsIssued(false);
				
				// resetTimer of book object
				book.resetTimer();
				
				//add book to abq queue
				abq.add(book);
				
				// remove book from student cart 
				student.getQueueCart().remove(book);
			}
		}

		// System.out.println("checkTimer thread completed");
	}

}
