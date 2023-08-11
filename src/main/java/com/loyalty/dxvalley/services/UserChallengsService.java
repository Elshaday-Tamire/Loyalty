package com.loyalty.dxvalley.services;

import java.util.List;

import com.loyalty.dxvalley.models.UserChallenge;


public interface UserChallengsService {
    List<UserChallenge> getUserChallengesByUsername (String username);
}
