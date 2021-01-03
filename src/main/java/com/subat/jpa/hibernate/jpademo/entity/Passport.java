package com.subat.jpa.hibernate.jpademo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	//mappedBy is used the non-owning side of the one to one relationship.
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
	Student student;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Passport() {
	}

	public Passport(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", name=" + name + "]";
	}

}
