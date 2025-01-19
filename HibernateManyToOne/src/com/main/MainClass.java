package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Book;
import com.entity.Publisher;

public class MainClass {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		cfg.addAnnotatedClass(Publisher.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Publisher publisher = new Publisher();
		publisher.setPublisherName("Penguin Random House");

		Book book1 = new Book();
		book1.setBookTitle("Java Programming Basics");
		book1.setPublisher(publisher);

		Book book2 = new Book();
		book2.setBookTitle("Advanced Hibernate Techniques");
		book2.setPublisher(publisher);

		session.persist(publisher); 
		session.persist(book1); 
		session.persist(book2); 

		tx.commit();
		session.close();
		sf.close();

		System.out.println("Many-to-One relationship data saved successfully!");
	}
}
