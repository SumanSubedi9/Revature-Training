package com.revature.spring.spring_jpa_rest_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.spring.spring_jpa_rest_application.model.GameInfo;

// This interface extends JpaRepository to provide CRUD operations for GameInfo entities.
public interface GameInfoRepository extends JpaRepository<GameInfo, Long> {

}
