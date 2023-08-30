package com.loyalty.dxvalley.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalty.dxvalley.models.DashboardData;
import com.loyalty.dxvalley.models.LevelDetails;
import com.loyalty.dxvalley.models.Levelss;
import com.loyalty.dxvalley.models.UserChallenge;
import com.loyalty.dxvalley.models.UserChallengeDTO;
import com.loyalty.dxvalley.models.Users;
import com.loyalty.dxvalley.repositories.LevelssRepository;
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
    private final LevelssRepository levelssRepository;
     Double points=0.0;
     String level="0";
    @Override
    public DashboardData getUserChallengesByUsername(String username) {
        Users users=userRepository.findByUsername(username);
        List<UserChallenge> userChallenges=userChallengeRepository.findUserChallengeByUsers(users);
        DashboardData dashboardData= new DashboardData();
       
        List<UserChallengeDTO> userChallengeDTOs= new ArrayList<UserChallengeDTO>();
        points=0.0;
        
        userChallenges.stream().forEach(uc->{
            System.out.println(uc.getChallenge().getChallengeName());
            UserChallengeDTO userChallengeDTO= new UserChallengeDTO();
            userChallengeDTO.setChallengeName(uc.getChallenge().getChallengeName());
            userChallengeDTO.setChallengeLogo(uc.getChallenge().getIcon());
            userChallengeDTO.setAffliateLink("https://play.google.com/store/apps/details?id=om.example.michuapp&user_id=1");
            userChallengeDTO.setPointsEarned(uc.getPoints().toString());
            userChallengeDTO.setAwardPoints("300");
            points+=uc.getPoints();
            userChallengeDTOs.add(userChallengeDTO);
        });
        dashboardData.setUserChallengeDTOs(userChallengeDTOs);
        dashboardData.setTotalPoints(points.toString());
        dashboardData.setEquivalentETB("10");
        dashboardData.setLevelColor("#dfb64d");
        dashboardData.setLevelName("Gold");

        List<Levelss> levelsses=levelssRepository.findAll();
        List<LevelDetails> levelDetailsArray= new ArrayList<LevelDetails>();
        levelsses.stream().forEach(l->{
            LevelDetails levelDetails= new LevelDetails();
            levelDetails.setLevelName(l.getLevelName());
            levelDetails.setPoints(l.getMaxValue().toString());
            levelDetails.setStatus("1");
            levelDetailsArray.add(levelDetails);
        });
        dashboardData.setLevelDetails(levelDetailsArray);
        return dashboardData;
    }
    @Override
    public List<UserChallenge> getAll() {
        return userChallengeRepository.findAll();
    }
    @Override
    public List<UserChallenge> getUserChallengesByuser(Users users) {
       return userChallengeRepository.findUserChallengeByUsers(users);
    }

}