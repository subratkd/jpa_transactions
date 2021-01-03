package com.subat.jpa.hibernate.jpademo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
import com.subat.jpa.hibernate.jpademo.entity.Review;
import com.subat.jpa.hibernate.jpademo.repository.CourseRepository;

@SpringBootTest(classes=JpaDemoApplication.class)
class CourseRepositoryTest {
private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseRepository courseRepo;
    
	@Test
	void findById_Basic() {
		Course course = courseRepo.findById(10001L);
		assertEquals("AEM", course.getName());
	}
	@Test
	@DirtiesContext
	void deleteById_Basic() {
		courseRepo.deleteById(10002L);
		assertNull(courseRepo.findById(10002L));
	}
	@Test
	@DirtiesContext
	void save_Basic() {
		Course course = new Course("Kafka");
		courseRepo.insertOrUpdate(course);
		assertEquals("Kafka",course.getName());
	}
	@Test
	@DirtiesContext
	void update_Basic() {
		Course course = new Course(1003L,"RabbitMq");
		courseRepo.insertOrUpdate(course);
		assertEquals("RabbitMq",course.getName());
	}
	
}
