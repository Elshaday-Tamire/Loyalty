package com.loyalty.dxvalley.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalty.dxvalley.models.UserChallenge;
import com.loyalty.dxvalley.models.Users;
import com.loyalty.dxvalley.repositories.UserChallengeRepository;
import com.loyalty.dxvalley.repositories.UserRepository;
import com.loyalty.dxvalley.services.UserChallengsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserChallengesServiceImpl implements UserChallengsService {
    @Autowired
    private final UserChallengeRepository userChallengeRepository;
    private  final UserRepository userRepository;

    @Override
    public List<UserChallenge> getUserChallengesByUsername(String username) {
        Users users=userRepository.findByUsername(username);
        return userChallengeRepository.findUserChallengeByUsers(users);
    }

}
