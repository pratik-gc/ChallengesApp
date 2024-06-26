package com.practiceprojectchallenges.ChallengeApp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
	private List<Challenge> challenges = new ArrayList<Challenge>();
	private Long nextId = 1L;

	public ChallengeService() {
		
	}
	
	public List<Challenge> getAllChallenges() {
		return challenges;
	}
	
	public boolean addChallenge(Challenge challenge) {
		if(challenge != null) {
			challenge.setId(nextId++);
			challenges.add(challenge);
			return true;
		}
		else {
			return false;
		}
	}

	public Challenge getChallenge(String month) {
		
		for(Challenge challenge : challenges) {
			if(challenge.getMonth().equalsIgnoreCase(month)) {
				return challenge;
			}
		}
		return null;
	}

	public boolean updateChallenge(Long id, Challenge modifiedChallenge) {
		for (Challenge challenge : challenges) {
			if(challenge.getId().equals(id)) {
				challenge.setMonth(modifiedChallenge.getMonth());
				challenge.setDescription(modifiedChallenge.getDescription());
				return true;
			}
				
		}
		return false;
	}

	public boolean deleteChallenge(Long id) {
		return challenges.removeIf(ch -> ch.getId().equals(id));
		
	}

}
