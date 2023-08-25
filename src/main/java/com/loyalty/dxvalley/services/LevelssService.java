package com.loyalty.dxvalley.services;

import java.util.List;


import com.loyalty.dxvalley.models.Levelss;

import ch.qos.logback.classic.Level;

public interface LevelssService {
    
    Levelss addLevelss (Levelss levelss);
    Levelss editLevelss (Levelss levelss);
    List<Levelss> getLevels ();
    Levelss getLevelById(Long levelId);
   
    
}
