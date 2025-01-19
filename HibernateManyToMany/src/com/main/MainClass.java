package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Student;

public class MainClass {

	public static void main(String[] args) {
        // Configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Course.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Create Courses
        Course math = new Course();
        math.setCourseName("Mathematics");

        Course physics = new Course();
        physics.setCourseName("Physics");

        // Create Students
        Student alice = new Student();
        alice.setStudentName("Alice");
        alice.getCourses().add(math);
        alice.getCourses().add(physics);

        Student bob = new Student();
        bob.setStudentName("Bob");
        bob.getCourses().add(math);

        // Add students to courses (bidirectional relationship)
        math.getStudents().add(alice);
        math.getStudents().add(bob);
        physics.getStudents().add(alice);

        // Save data
        session.persist(alice);
        session.persist(bob);

        tx.commit();
        session.close();
        sf.close();

        System.out.println("Many-to-Many relationship data saved successfully!");
    }
}
