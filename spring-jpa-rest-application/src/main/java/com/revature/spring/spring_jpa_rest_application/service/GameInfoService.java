package com.revature.spring.spring_jpa_rest_application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.spring.spring_jpa_rest_application.model.GameInfo;
import com.revature.spring.spring_jpa_rest_application.repository.GameInfoRepository;

@Service
public class GameInfoService {

    // Dependency on the GameInfoRepository to perform database operations
    private final GameInfoRepository gameInfoRepository;

    // Constructor injection of the repository
    public GameInfoService(GameInfoRepository gameInfoRepository) {
        this.gameInfoRepository = gameInfoRepository;
    }

    // Method to retrieve all game information from the database

    public List<GameInfo> getAllGames() {
        return gameInfoRepository.findAll();
    }

    // Method to retrieve a specific game by its ID
    public GameInfo getGameById(Long id) {
        return gameInfoRepository.findById(id).orElse(null);
    }

    // Method to add a new game to the database
    public GameInfo addGame(GameInfo gameInfo) {
        return gameInfoRepository.save(gameInfo);
    }

    // Method to add multiple games to the database at once
    public List<GameInfo> addMultipleGames(List<GameInfo> games) {
        return gameInfoRepository.saveAll(games);
    }

    // Method to update an existing game's information
    public GameInfo updateGame(Long id, GameInfo updatedGameInfo) {

        GameInfo existingGameInfo = getGameById(id);
        existingGameInfo.setTitle(updatedGameInfo.getTitle());
        existingGameInfo.setGenre(updatedGameInfo.getGenre());
        existingGameInfo.setPlatform(updatedGameInfo.getPlatform());
        existingGameInfo.setPrice(updatedGameInfo.getPrice());

        return gameInfoRepository.save(existingGameInfo);
    }

    // Method to delete a game from the database by its ID
    public void deleteGame(Long id) {
        gameInfoRepository.deleteById(id);
    }

}
