package com.loyalty.dxvalley.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyalty.dxvalley.models.Level;

public interface LevelRepository extends JpaRepository<Level,Long> {
    
}
