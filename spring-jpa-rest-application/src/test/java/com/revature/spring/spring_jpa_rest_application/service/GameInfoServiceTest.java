package com.revature.spring.spring_jpa_rest_application.service;

import com.revature.spring.spring_jpa_rest_application.model.GameInfo;
import com.revature.spring.spring_jpa_rest_application.repository.GameInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameInfoServiceTest {

    @Mock
    private GameInfoRepository gameInfoRepository;

    @InjectMocks
    private GameInfoService gameInfoService;

    @Test
    void testGetAllGames() {
        // Arrange
        GameInfo game1 = new GameInfo(1L, "Game 1", "Action", "PC", 29.99);
        GameInfo game2 = new GameInfo(2L, "Game 2", "RPG", "PlayStation", 59.99);
        List<GameInfo> mockGames = Arrays.asList(game1, game2);

        when(gameInfoRepository.findAll()).thenReturn(mockGames);

        // Act
        List<GameInfo> result = gameInfoService.getAllGames();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Game 1", result.get(0).getTitle());
        verify(gameInfoRepository, times(1)).findAll();
    }

    @Test
    void testGetGameById() {
        // Arrange
        GameInfo mockGame = new GameInfo(1L, "Test Game", "Action", "PC", 29.99);
        when(gameInfoRepository.findById(1L)).thenReturn(Optional.of(mockGame));

        // Act
        GameInfo result = gameInfoService.getGameById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Test Game", result.getTitle());
        assertEquals(1L, result.getId());
        verify(gameInfoRepository, times(1)).findById(1L);
    }

    @Test
    void testAddGame() {
        // Arrange
        GameInfo inputGame = new GameInfo(null, "New Game", "Adventure", "Switch", 39.99);
        GameInfo savedGame = new GameInfo(1L, "New Game", "Adventure", "Switch", 39.99);

        when(gameInfoRepository.save(any(GameInfo.class))).thenReturn(savedGame);

        // Act
        GameInfo result = gameInfoService.addGame(inputGame);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Game", result.getTitle());
        verify(gameInfoRepository, times(1)).save(inputGame);
    }

    @Test
    void testAddMultipleGames() {
        // Arrange
        GameInfo game1 = new GameInfo(null, "Game 1", "Action", "PC", 29.99);
        GameInfo game2 = new GameInfo(null, "Game 2", "RPG", "PlayStation", 59.99);
        List<GameInfo> inputGames = Arrays.asList(game1, game2);

        GameInfo savedGame1 = new GameInfo(1L, "Game 1", "Action", "PC", 29.99);
        GameInfo savedGame2 = new GameInfo(2L, "Game 2", "RPG", "PlayStation", 59.99);
        List<GameInfo> savedGames = Arrays.asList(savedGame1, savedGame2);

        when(gameInfoRepository.saveAll(inputGames)).thenReturn(savedGames);

        // Act
        List<GameInfo> result = gameInfoService.addMultipleGames(inputGames);

        // Assert
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
        verify(gameInfoRepository, times(1)).saveAll(inputGames);
    }
}