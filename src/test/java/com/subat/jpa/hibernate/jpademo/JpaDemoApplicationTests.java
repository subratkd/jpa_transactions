package com.subat.jpa.hibernate.jpademo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.assertj.core.util.Arrays;
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
class JpaDemoApplicationTests {
private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    CourseRepository course;

    @Autowired
    EntityManager em;
    
    
    @Test
    void typed_basic() {
    	Query query = em.createQuery("Select c from Course c");
    	List resultList = query.getResultList();
    	logger.info("Select c from Course=> {}",resultList);
    }
    @Test
    void named_typed() {
    	TypedQuery<Course> query = em.createQuery("Select c from Course c",Course.class);
    	List<Course> resultList = query.getResultList();
    	logger.info("Select c from Course Named=> {}",resultList);
    }
    @Test
    void where_typed() {
    	TypedQuery<Course> query = em.createQuery("Select c from Course c where name like 'Spring%'",Course.class);
    	List<Course> resultList = query.getResultList();
    	logger.info("Select c from Course c where name like 'Spring%'",resultList);
    }
    @Test
	@Transactional
	@DirtiesContext
	void addReviewsForCourseTest() {
		List<Review> reviewList = new ArrayList<Review>();
		Course review = em.find(Course.class, 10003L);
		int size = review.getReviews().size();
		reviewList.add(new Review("5", "Nice course"));
		course.addReviewsForCourse(10003L, reviewList);
		Course newRview = em.find(Course.class, 10003L);
		int newSize = newRview.getReviews().size();
		assertEquals(size + 1, newSize);

	}
    
   
	
}
