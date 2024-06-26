package com.practiceprojectchallenges.ChallengeApp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRespositoryIntrf extends JpaRepository<Challenge, Long>{

	// all customized methods which as not part of standard JPA methods need to be declared here
	// Upon declaring, hibernate will take of them during runtime
	
	// findByMonthIgnoreCase(month) is a customized method
	Optional<Challenge> findByMonthIgnoreCase(String month);

}
