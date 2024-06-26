package com.practiceprojectchallenges.ChallengeApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Challenge {
	
	@Id
	private Long id;

	// bcz "column" is a reserved word in database world, we will get an error while executing
	// DDL command i.e. Create Table..... Therefore, we need to change the name to something else.
	@Column(name="challengeMonth")
	private String month;
	
	private String description;
	
	// default constructor is needed otherwise we will get org.hibernate.InstantiationException
	//underlying tool that JPA uses is Hibernate and Hibernate requires default constructor first to instantiate
	// entities before populating them with data from the database. 
	public Challenge() {
		
	}
	
	// parameterized constructor
	public Challenge(Long id, String month, String description) {
		super();
		this.id = id;
		this.month = month;
		this.description = description;
	}

	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
