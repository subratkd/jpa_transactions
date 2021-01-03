package com.subat.jpa.hibernate.jpademo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subat.jpa.hibernate.jpademo.entity.Passport;
import com.subat.jpa.hibernate.jpademo.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	@Autowired
	EntityManager em;

	public Student findById(Long id) {

		return em.find(Student.class, id);
	}

	public Student insertOrUpdate(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	public void saveStudentWithPassport() {
		Passport passport = new Passport("E123456");
		em.persist(passport);
		//Student owns the Passport entity . So Passport should be persisted before Student.
		Student student = new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
		
	}
	
	public void persistenceContextTest() {
    	//DataBase operation1-  Retrieve Student
    	 Student student = em.find(Student.class, 20001L);
    	 //Persistence Context (Student)
    	 
    	//DataBase operation2-  Retrieve Passport
    	 //if we comment @Transactional then line no 58 will give error . 
    	 //as Session closed 
    	 Passport passport = student.getPassport();
    	//Persistence Context (Student,Passport)
    	 
    	//DataBase operation3-  update Passport
    	 passport.setName("E123457");
    	//Persistence Context (Student,Passport++)
    	 
    	//DataBase operation4-  update Student
    	 student.setName("Ranga -Updated");
    	//Persistence Context (Student++,Passport++)
    	
    	 //The queries will be fired at the end of the transaction.
    	 //we interact with the persistence context using the Entity Manager.
    	
    }

	
}
