package com.loyalty.dxvalley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.loyalty.dxvalley.models.UserChallenge;
import com.loyalty.dxvalley.services.UserChallengsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/userChallenges")
public class UserChallengsController {
    @Autowired
    private final UserChallengsService userChallengsService;
  @GetMapping("/getByUsername/{username}")
  List<UserChallenge> getAll(@PathVariable String username) {
   return userChallengsService.getUserChallengesByUsername(username);
  }
}
