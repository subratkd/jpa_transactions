package com.subat.jpa.hibernate.jpademo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subat.jpa.hibernate.jpademo.entity.Course;
@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager em;
	
	public Course findById(int id){
		
		return em.find(Course.class, id);
	}
	public Course insertOrUpdate(Course course) {
		return em.merge(course);
	}
	public void deleteById(int id) {
		
	}
	

}
