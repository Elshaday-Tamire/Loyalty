package com.loyalty.dxvalley.services;

import com.loyalty.dxvalley.models.DashboardData;



public interface UserChallengsService {
    DashboardData getUserChallengesByUsername (String username);
}
