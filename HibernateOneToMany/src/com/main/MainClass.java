package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Department.class);
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Department dept = new Department();
		dept.setDeptName("IT Department");

		Employee emp1 = new Employee();
		emp1.setEmpName("Shruti");

		Employee emp2 = new Employee();
		emp2.setEmpName("Bhavesh");

		dept.addEmployee(emp1);
		dept.addEmployee(emp2);

		session.persist(dept);

		tx.commit();
		session.close();
		sf.close();

		System.out.println("One-to-Many relationship data saved successfully!");
	}
}
