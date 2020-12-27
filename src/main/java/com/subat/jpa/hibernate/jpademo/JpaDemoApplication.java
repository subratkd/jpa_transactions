package com.subat.jpa.hibernate.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subat.jpa.hibernate.jpademo.entity.Course;
import com.subat.jpa.hibernate.jpademo.repository.CourseRepository;

@SpringBootApplication
public class JpaDemoApplication  implements CommandLineRunner{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		courseRepo.insertOrUpdate(new Course("Tom"));
		courseRepo.insertOrUpdate(new Course("Jerry"));
		courseRepo.insertOrUpdate(new Course("Alex"));
		log.info("get By Id {}"+courseRepo.findById(1));
		
	}

}
