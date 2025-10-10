package com.revature.spring.spring_jpa_rest_application.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.spring.spring_jpa_rest_application.model.GameInfo;
import com.revature.spring.spring_jpa_rest_application.service.GameInfoService;

// annotation to indicate that this class is a REST controller
@RestController
@RequestMapping("/games")

public class GameInfoController {

    // Dependency on the GameInfoService to handle business logic
    private final GameInfoService gameInfoService;

    public GameInfoController(GameInfoService gameInfoService) {
        this.gameInfoService = gameInfoService;
    }

    // Additional methods to handle HTTP requests (GET, POST, PUT, DELETE)

    // Example: Get all games
    @GetMapping
    public List<GameInfo> getAllGames() {
        return gameInfoService.getAllGames();
    }

    // Example: Get a game by ID
    @GetMapping("/{id}")
    public GameInfo getGameById(@PathVariable Long id) {
        return gameInfoService.getGameById(id);
    }

    // Example: Add a new game
    @PostMapping
    public ResponseEntity<GameInfo> addGame(@RequestBody GameInfo game) {
        return ResponseEntity.ok(gameInfoService.addGame(game));
    }

    // Example: Add multiple games at once
    @PostMapping("/batch")
    public ResponseEntity<List<GameInfo>> addMultipleGames(@RequestBody List<GameInfo> games) {
        return ResponseEntity.ok(gameInfoService.addMultipleGames(games));
    }

    // Example: Update an existing game
    @PutMapping("/{id}")
    public ResponseEntity<GameInfo> updateGame(@PathVariable Long id, @RequestBody GameInfo game) {
        return ResponseEntity.ok(gameInfoService.updateGame(id, game));
    }

    // Example: Delete a game by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameInfoService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

}
