package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setAge(20);
		student1.setName("raju");

		Student student2 = new Student();
		student2.setAge(30);
		student2.setName("karan");

		Student student3 = new Student();
		student3.setAge(10);
		student3.setName("sharma");

		Course course1 = new Course();
		course1.setDuration("3 to 5");
		course1.setName("java");

		Course course2 = new Course();
		course2.setDuration("6 to 8");
		course2.setName("python");

		Course course3 = new Course();
		course3.setDuration("  5");
		course3.setName("html");

		List<Course> courses1 = new ArrayList<Course>();
		courses1.add(course1);
		courses1.add(course2);
		courses1.add(course3);
		student1.setCourses(courses1);

		List<Course> courses2 = new ArrayList<Course>();
		courses2.add(course1);
		courses2.add(course2);
		student2.setCourses(courses2);

		List<Course> courses3 = new ArrayList<Course>();
		courses3.add(course1);
		courses3.add(course3);
		student3.setCourses(courses3);

		List<Student> students1 = new ArrayList<Student>();
		students1.add(student1);
		students1.add(student2);
		students1.add(student3);
		course1.setStudents(students1);

		List<Student> students2 = new ArrayList<Student>();
		students2.add(student1);
		students2.add(student2);
		course2.setStudents(students2);

		List<Student> students3 = new ArrayList<Student>();
		students3.add(student1);
		students3.add(student3);
		course3.setStudents(students3);

		entityTransaction.begin();
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityTransaction.commit();

	}

}
