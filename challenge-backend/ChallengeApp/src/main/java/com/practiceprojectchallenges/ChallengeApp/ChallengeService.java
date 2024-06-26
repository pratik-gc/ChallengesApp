package com.practiceprojectchallenges.ChallengeApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
	// private List<Challenge> challenges = new ArrayList<Challenge>();
	private Long nextId = 1L;
	
	@Autowired
	ChallengeRespositoryIntrf challengeRepository;

	public ChallengeService() {
		
	}
	
	public List<Challenge> getAllChallenges() {
		return challengeRepository.findAll();
	}
	
	public boolean addChallenge(Challenge challenge) {
		if(challenge != null) {
			challenge.setId(nextId++);
			challengeRepository.save(challenge);
			return true;
		}
		else {
			return false;
		}
	}

	public Challenge getChallenge(String month) {
		// findByMonthIgnoreCase(month) is a customized method
		Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
		
		return challenge.orElse(null);
	}

	public boolean updateChallenge(Long id, Challenge modifiedChallenge) {
		Optional<Challenge> challenge = challengeRepository.findById(id);
		if(challenge.isPresent()) {
			Challenge challengeToUpdate = challenge.get();
			challengeToUpdate.setMonth(modifiedChallenge.getMonth());
			challengeToUpdate.setDescription(modifiedChallenge.getDescription());
			challengeRepository.save(challengeToUpdate);
			return true;
		}
	
		return false;
	}

	public boolean deleteChallenge(Long id) {
		Optional<Challenge> challenge = challengeRepository.findById(id);
		if(challenge.isPresent()) {
			challengeRepository.deleteById(id);
			return true;
		}
		else
			return false;
		
	}

}
