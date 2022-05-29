package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person1=new Person();
		person1.setName("manoj");
		person1.setPhone(3311);
		
		Person person2=new Person();
		person2.setName("karthik");
		person2.setPhone(3322);
		
		Person person3=new Person();
		person3.setName("chandu");
		person3.setPhone(33266211);
		
		Cab cab1=new Cab();
		cab1.setDriver_name("sufiyan");
		cab1.setCost(100);
		
		Cab cab2=new Cab();
		cab2.setDriver_name("suhas");
		cab2.setCost(600);
		
		Cab cab3=new Cab();
		cab3.setDriver_name("mohith");
		cab3.setCost(900);
		
		
		List<Cab> cabs1=new ArrayList<Cab>();
		cabs1.add(cab1);
		cabs1.add(cab2);
		cabs1.add(cab3);
		person1.setCabs(cabs1);
		
		List<Cab> cabs2=new ArrayList<Cab>();
		cabs2.add(cab1);
		cabs2.add(cab2);
		person2.setCabs(cabs2);
		
		List<Cab> cabs3=new ArrayList<Cab>();
		cabs3.add(cab1);
		cabs3.add(cab3);
		person3.setCabs(cabs3);
		
		List<Person> persons1=new ArrayList<Person>();
		persons1.add(person1);
		persons1.add(person2);
		persons1.add(person3);
		cab1.setPersons(persons1);
		
		List<Person> persons2=new ArrayList<Person>();
		persons2.add(person1);
		persons2.add(person2);
		cab2.setPersons(persons2);
		
		
		List<Person> persons3=new ArrayList<Person>();
		persons3.add(person1);
		persons3.add(person3);
		cab3.setPersons(persons3);
		
		entityTransaction.begin();
		entityManager.persist(cabs1);
		entityManager.persist(cabs2);
		entityManager.persist(cabs3);

		entityManager.persist(persons1);
		entityManager.persist(persons2);
		entityManager.persist(persons3);
		
		entityTransaction.commit();

		
		
		
		
		
		
		
		
	}

}
