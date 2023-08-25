package com.loyalty.dxvalley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.loyalty.dxvalley.models.Challenge;
import com.loyalty.dxvalley.services.ChallengsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/challengs")
public class ChallengsController {

  @Autowired
  private final ChallengsService challengsService;
  @GetMapping("/getAll")
  List<Challenge> getAll() {
   return challengsService.getChallenges();
  }

  @GetMapping("/{challengeId}")
  Challenge getChallenge(@PathVariable Long challengeId){
    return challengsService.getChallengeById(challengeId);
  }

}
