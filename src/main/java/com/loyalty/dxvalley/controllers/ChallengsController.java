package com.loyalty.dxvalley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.loyalty.dxvalley.models.Challenge;
import com.loyalty.dxvalley.models.CreateResponse;

import com.loyalty.dxvalley.services.ChallengsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/challengs")
public class ChallengsController {

  @Autowired
  private final ChallengsService challengsService;

    @PostMapping("/addChallenge")
    public ResponseEntity<CreateResponse> addChallenge (@RequestBody Challenge challenge) {
        challengsService.addChallenge(challenge);
        CreateResponse response = new CreateResponse("Success","Challenge created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    } 
    @PutMapping("/edit/{challengId}")
      Challenge editChallenge(@RequestBody Challenge tempChallenge, @PathVariable Long challengId) {
        Challenge challenge = this.challengsService.getChallengeById(challengId);
        challenge.setChallengeName(tempChallenge.getChallengeName());
        challenge.setDescription(tempChallenge.getDescription());
        challenge.setIcon(tempChallenge.getIcon()); 
        challenge.setIsEnabled(tempChallenge.getIsEnabled());
        challenge.setMaxPoints(tempChallenge.getMaxPoints());
        challenge.setPoints(tempChallenge.getPoints());
        challenge.setProductCataloge(tempChallenge.getProductCataloge());
        challenge.setCategory(tempChallenge.getCategory());
        return challengsService.editChallenge(challenge);
    }
  @GetMapping("/getAll")
  List<Challenge> getAll() {
   return challengsService.getChallenges();
  }

  @GetMapping("/{challengeId}")
  Challenge getChallenge(@PathVariable Long challengeId){
    return challengsService.getChallengeById(challengeId);
  }

}
