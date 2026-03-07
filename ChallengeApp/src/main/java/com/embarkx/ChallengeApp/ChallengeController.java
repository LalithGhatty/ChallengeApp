package com.embarkx.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//JPA-JAVA PERSISTANCE API
@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }
    @GetMapping()
    public List<Challenge> getAllChallenges(){

        return challengeService.getAllChallenges();
    }
   @PostMapping()
    public String addChallenge(@RequestBody  Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if(isChallengeAdded){
            return "Challenge Added successfully";
        }
        else{
            return "Challenge not Added successfully";
        }
    }
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable  String month){
          Challenge challenge = challengeService.getChallenge(month);
          if(challenge != null){
              return new ResponseEntity<>(challenge, HttpStatus.OK);
          }
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallange){
        boolean isChallengedUpdated = challengeService.updateChallenge(id,updatedChallange);
        if(isChallengedUpdated){
            return new ResponseEntity("Challenge updated successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity("Challenged not updated successfully",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            return new ResponseEntity("Challenge Deleted Successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity("Challenged not deleted Successfully",HttpStatus.NOT_FOUND);
        }
    }
}
