package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Laptop;
import com.entity.Student;

public class MainClass {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Laptop.class);
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		
		Laptop l1 = new Laptop();
		l1.setLid(101);
		l1.setLname("HP");
		
		Student s1 = new Student();
		s1.setSid(501);
		s1.setSname("Yash");
		s1.setLaptop(l1);
		
		ss.persist(s1);
		tr.commit();
		ss.close();
		System.out.println("Data Added succesfully!!!");
	}
}
