package com.embarkx.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private static List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;
    public ChallengeService(){
        Challenge challenge1 = new Challenge(1L,"January","Learn a  new programming language");
        challenges.add(challenge1);
    }
    public  static List<Challenge> getAllChallenges(){
        return challenges;
    }
    public boolean addChallenge(Challenge challenge){
        if(challenge != null){
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else{
            return false;
        }
    }

    public Challenge getChallenge(String month) {
        for(Challenge challenge:challenges) {
            if (challenge.getMonth().equals(month)) {
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge updatedChallange) {
        for(Challenge challenge:challenges){
            if(challenge.getId().equals(id)){
                challenge.setMonth((updatedChallange.getMonth()));
                challenge.setDescription((updatedChallange.getDescription()));
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
}
