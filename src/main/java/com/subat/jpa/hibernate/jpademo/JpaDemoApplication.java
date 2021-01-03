package com.subat.jpa.hibernate.jpademo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subat.jpa.hibernate.jpademo.entity.Course;
import com.subat.jpa.hibernate.jpademo.entity.Review;
import com.subat.jpa.hibernate.jpademo.repository.CourseRepository;
import com.subat.jpa.hibernate.jpademo.repository.StudentRepository;

@SpringBootApplication
public class JpaDemoApplication  implements CommandLineRunner{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	StudentRepository studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//studentRepo.saveStudentWithPassport();
		/*
		 * courseRepo.addReviewsForCourse(10003L,Arrays.asList(new Review("5",
		 * "Excellent course!"), new Review("5", "Fantastic course!")));
		 */
	}

}
