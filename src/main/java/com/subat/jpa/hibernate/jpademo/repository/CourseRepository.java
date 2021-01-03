package com.subat.jpa.hibernate.jpademo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subat.jpa.hibernate.jpademo.entity.Course;
import com.subat.jpa.hibernate.jpademo.entity.Review;
@Repository
@Transactional
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	public Course findById(Long id){
		
		return em.find(Course.class, id);
	}
	public Course insertOrUpdate(Course course) {
		if(course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
     return course;		
	}
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	public void playWithEntity() {
		//persistence context
		Course course1 = new Course("WebServices1 in 100 Steps");
		//saves to DB
		em.persist(course1);
		Course course2 = new Course("WebServices2 in 100 Steps");
		//saves to db
		em.persist(course2);
		//saves to db immediately
		em.flush();
		//we are detaching course 2 .So any further changes to course2 object will not be saved.
		//em.detach(course2);
		//clear() closes the entity manager immediately.The changes will not be saved.
		em.clear();
		course1.setName("WebServices1 in 100 Steps--updated");
		em.flush();
		course2.setName("WebServices2 in 100 Steps--updated");
		em.flush();
		
		
	}
	public void refreshData() {
		//persistence context
		Course course1 = new Course("WebServices1 in 100 Steps");
		//saves to DB
		em.persist(course1);
		Course course2 = new Course("WebServices2 in 100 Steps");
		//saves to db
		em.persist(course2);
		//saves to db immediately
		em.flush();
		course1.setName("WebServices1 in 100 Steps--updated");
		course2.setName("WebServices2 in 100 Steps--updated");
		em.refresh(course1);
		
		
	}
	
	public void addReviewsForCourse(Long id,List<Review> reviews) {
		Course course = em.find(Course.class,id);
		logger.info("course.getReviews() --> {}",course.getReviews().toString());
		for (Review review: reviews) {
			 course.addReview(review);
			 review.setCourse(course);
			em.persist(review);
		}
		
	}

}
