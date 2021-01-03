package com.subat.jpa.hibernate.jpademo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.Assert;

import com.subat.jpa.hibernate.jpademo.entity.Course;
import com.subat.jpa.hibernate.jpademo.entity.Passport;
import com.subat.jpa.hibernate.jpademo.entity.Student;
import com.subat.jpa.hibernate.jpademo.repository.CourseRepository;
import com.subat.jpa.hibernate.jpademo.repository.StudentRepository;

@SpringBootTest(classes=JpaDemoApplication.class)
class StudentRepositoryTest {
private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentRepository studentRepo;
    
    @Autowired
    EntityManager em;
    
    @Test
    @Transactional
    @DirtiesContext
    void retireveStudentAndPassportDetails() {
     Student student = em.find(Student.class, 20001L);
     logger.info("Student => {}", student);
     logger.info("Pasport => {}", student.getPassport());
    }
    @Test
    @Transactional
    @DirtiesContext
    void retirevePassportAndStudentDetails() {
     Passport passport = em.find(Passport.class, 40001L);
     logger.info("passport => {}", passport);
     logger.info("Student => {}", passport.getStudent());
    }
    // Hibernate uses Session and Session Factory which is not required if we use JPA
    //Entity Manager and Persistence Context
    //Transaction
    @Test
    @Transactional
    @DirtiesContext
    //Transactional means if something fails then nothing will 
    //be saved and everything is going to rollback.
    void sameTest() {
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
    
    @Test
    @DirtiesContext
    void anotherTest() {
    	studentRepo.persistenceContextTest();
    }
    
    @Test
    @Transactional
    @DirtiesContext
    void retrieveStudentAndCourses() {
      Student student = em.find(Student.class, 20001L);
      List<Course> courses = student.getCourses();
      logger.info("student ======>{}", student);
      logger.info("courses ======>{}", courses);
    }
    
    // ManyToOne and OneToOne default fetch type is eager
    
    @Test
    @Transactional
    @DirtiesContext
    void retrieveCoursesAndStudents() {
      Course course = em.find(Course.class, 10001L);
      List<Student> students = course.getStudents();
      logger.info("courses ======>{}", course);

      logger.info("student ======>{}", students);
    }
    
    
}
