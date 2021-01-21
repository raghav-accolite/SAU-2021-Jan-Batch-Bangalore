package com.au.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class LibraryManager {
	public static SessionFactory factory;
	public static void main(String[] args) {
		try {
		factory = new Configuration().configure().buildSessionFactory();
	}
		catch(Exception e) {
			System.err.println(e);
		}
		LibraryManager libraryManager = new LibraryManager();

		libraryManager.addBook("Book1","en",2021);
		libraryManager.addBook("Book2","en",2021);
		libraryManager.addBook("Book3","en",2021);
		libraryManager.addBook("Book4","en",2021);
		libraryManager.addBook("Book5","en",2021);
		Book book = libraryManager.getBookById(1);
		if(book!=null) {
			System.out.println("Name - "+book.getName());
			System.out.println("Language - "+book.getLanguage());
			System.out.println("Publish Year - "+book.getPublishYear());
		}
		else {
			System.out.println("Book not found");
		}
		libraryManager.updateBookById(1,new Book("book1 Update","Hindi",2000));
		libraryManager.deleteBookById(2);
		libraryManager.getBookCount();
		
		
		
}
	private void getBookCount() {
		Session session = factory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			long count = (long)session.createQuery("SELECT COUNT(l) FROM Book l").getSingleResult();
			System.out.println("No of rows - "+count);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
	}
	private void updateBookById(int i,Book b) {
		Session session = factory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			b.setId(i);
			session.update(b);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
	}
	private void deleteBookById(int i) {
		Session session = factory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			Book b = new Book();
			b.setId(i);
			b.setId(i);
			session.remove(b);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
	}
	private Book getBookById(int i) {
		Session session = factory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			Book book = session.get(Book.class, i);
			tx.commit();
			return book;
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
		return null;
		
	}
	private void getBooks() {
		Session session = factory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			List<Book> movieList = session.createQuery("FROM Book").list();
			for(Book result : movieList) {
				System.out.print(result.getId()+" ");
				System.out.print(result.getLanguage()+" ");
				System.out.print(result.getName()+" ");
				System.out.print(result.getPublishYear()+" ");
				System.out.println( );
			}
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
		
	}

	private Integer addBook(String name,String language,int publishYear) {
		Transaction tx=null;
		Session session = factory.openSession();
		Integer bookId=null;
		try {
			tx= session.beginTransaction();
			Book movie = new Book(name,language,publishYear);
			bookId = (Integer) session.save(movie);
			tx.commit();
			//List<Movie> result= session.createQuery("FROM Movie").list();
			}
		catch(Exception e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
			
		}
		return bookId;
	}

}
