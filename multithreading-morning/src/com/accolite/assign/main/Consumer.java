package com.accolite.assign.main;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import com.accolite.assign.model.Book;
import com.accolite.assign.model.Student;
import com.accolite.assign.service.DecisionServce;

/*
 * 
 * Consumer class have abq queue and student fields
 * 
 * ReentrantLock is used for reviewBook() for add to the cart 
 * 
 */
public class Consumer implements Runnable {

	ArrayBlockingQueue<Book> abq;
	Student student;

	private static ReentrantLock lock = new ReentrantLock();

	// creating object of timer class 
	Timer timer = new Timer();

	public Consumer(ArrayBlockingQueue<Book> abq, Student student) {
		this.abq = abq;
		this.student = student;

	}

	@Override
	public void run() {

		// creating TimerCheck object
		TimerTask task = new TimerCheck(abq, student);

		// run after 1 sec for check time limit exceed of the books into student cart
		timer.schedule(task, 1000);

		try {

			// infinity till user don;t want to checkout book or exit
			// that decision come from decision service class randomly

			while (true) {

				// Decision for review  book
				if (DecisionServce.getDecision()) {
					// show all the books i.e available
					showBooks();

					// lock reviewBook() method to give synchronized for add book to the cart
					lock.lock();
					
					reviewBook();
					
					// Once add into cart agin unlock so another user can add into own cart
					lock.unlock();
				}

				// Decision for checkout books after that return
				if (DecisionServce.getDecision()) {

					checkOutBook();

					break;
				}

				// taking desicison to exit from library randomly from DecisionService class
				if (DecisionServce.getDecision()) {
					System.out.println("Exit");
					break;
				}

				// Thread.sleep(2000); // is used to check CheckTimer thread

				// System.out.println("Taking time student " + student.getId());

			}
		} catch (Exception e) {
			System.out.println("Exception " + e);
		} finally {
			
			// book in student cart moing again into abq queue after checkout or exist from library 
			student.getQueueCart().forEach(book -> {
				// setIsIssued to false of book
				book.setIsIssued(false);
				
				// reset timer 
				book.resetTimer();
				
				// add book to abq 
				abq.add(book);

			});
			// clear the student cart 
			student.getQueueCart().clear();
			
			// stop timerCheck schedule 
			timer.cancel();
		}

	}

	// ShowBooks() is used to print all available books
	public void showBooks() {

		System.out.print("Student id " + student.getId());
		// creating iterator of abq queue with Book object type
		Iterator<Book> it = abq.iterator();

		while (it.hasNext()) {
			Book book = it.next();

			// those book is not issued show to user
			if (book.getIsIssued() == false) {
				System.out.print(book.getName() + "\t");
				System.out.print(book.getAuthorName() + "\t");
				System.out.print(book.getIsbnNo() + "\t");
				System.out.print(book.getId() + "\t");
				System.out.println();
			}
		}
	}

	public void reviewBook() {

		// System.out.println("Inside reviewBook student id and size" +
		// student.getName() + abq.size());

		if (abq.size() > 0) {

			// selecting random number for getting book to take review and add to the cart
			int selection = DecisionServce.getSelection(abq.size());

			// System.out.println("selection number " + selection);
			Iterator<Book> it = abq.iterator();

			// reaching to that book
			for (int i = 0; it.hasNext() && i <= selection; i++) {
				Book book = it.next();
				if (i == selection) {
					// setIsIssued field true of the book
					book.setIsIssued(true);

					// System.out.println("return book " + book.getId());

					// removing book from abq so not show to another student
					abq.remove(book);

					// book add to the cart fr future review
					student.addBooktocart(book);

					// start timer of the book so track out limit time
					book.startTimer();

				}
			}
		}

	}

	// CheckoutBook() method is used to checkout blook
	public void checkOutBook() {

		if (student.getQueueCart().size() > 0) {

			// selecting random number for checkout from cart
			int selection = DecisionServce.getSelection(student.getQueueCart().size());

			// System.out.println("selection number " + selection);

			Iterator<Book> it = student.getQueueCart().iterator();

			// used to reach that book by using iterator
			for (int i = 0; it.hasNext() && i <= selection; i++) {

				Book book = it.next();
				if (i == selection) {
					// setCheckout() true
					book.setIscheckOut(true);

					// setCheckoutBook() to the student one-one realtionship
					student.setCheckoutBook(book);

					// addStudentDetails() to the book object i.e checkout that book
					book.addStudentDetails(student);

					// System.out.println("checkout book " + book.getId());

					// remove book from the student cart
					student.getQueueCart().remove(book);

					// resetTimer() of the book object
					book.resetTimer();

				}
			}
		}
	}

}
