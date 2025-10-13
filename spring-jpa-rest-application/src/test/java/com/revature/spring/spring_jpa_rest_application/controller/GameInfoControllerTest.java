package com.revature.spring.spring_jpa_rest_application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.spring.spring_jpa_rest_application.model.GameInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class GameInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllGames() throws Exception {
        mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(3))))
                .andExpect(jsonPath("$[0].title", is("Test Game 1")))
                .andExpect(jsonPath("$[0].genre", is("Action")))
                .andExpect(jsonPath("$[0].platform", is("PC")))
                .andExpect(jsonPath("$[0].price", is(29.99)));
    }

    @Test
    void testGetGameById() throws Exception {
        mockMvc.perform(get("/games/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Test Game 1")))
                .andExpect(jsonPath("$.genre", is("Action")));
    }

    @Test
    void testAddGame() throws Exception {
        GameInfo newGame = new GameInfo();
        newGame.setTitle("New Test Game");
        newGame.setGenre("Adventure");
        newGame.setPlatform("Nintendo Switch");
        newGame.setPrice(39.99);

        mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newGame)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is("New Test Game")))
                .andExpect(jsonPath("$.genre", is("Adventure")))
                .andExpect(jsonPath("$.platform", is("Nintendo Switch")))
                .andExpect(jsonPath("$.price", is(39.99)))
                .andExpect(jsonPath("$.id", notNullValue()));
    }

    @Test
    void testAddMultipleGames() throws Exception {
        GameInfo game1 = new GameInfo();
        game1.setTitle("Batch Game 1");
        game1.setGenre("Strategy");
        game1.setPlatform("PC");
        game1.setPrice(24.99);

        GameInfo game2 = new GameInfo();
        game2.setTitle("Batch Game 2");
        game2.setGenre("Sports");
        game2.setPlatform("PlayStation 5");
        game2.setPrice(49.99);

        List<GameInfo> games = Arrays.asList(game1, game2);

        mockMvc.perform(post("/games/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(games)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Batch Game 1")))
                .andExpect(jsonPath("$[1].title", is("Batch Game 2")));
    }

    @Test
    void testUpdateGame() throws Exception {
        GameInfo updatedGame = new GameInfo();
        updatedGame.setTitle("Updated Test Game");
        updatedGame.setGenre("Updated Genre");
        updatedGame.setPlatform("Updated Platform");
        updatedGame.setPrice(99.99);

        mockMvc.perform(put("/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedGame)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Updated Test Game")))
                .andExpect(jsonPath("$.genre", is("Updated Genre")))
                .andExpect(jsonPath("$.platform", is("Updated Platform")))
                .andExpect(jsonPath("$.price", is(99.99)));
    }

    @Test
    void testDeleteGame() throws Exception {
        mockMvc.perform(delete("/games/1"))
                .andDo(print())
                .andExpect(status().isNoContent());

        // Verify the game is deleted
        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void testAddGameWithInvalidData() throws Exception {
        GameInfo invalidGame = new GameInfo();
        // Missing required fields

        mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidGame)))
                .andDo(print())
                .andExpect(status().isOk()); // This might need adjustment based on your validation
    }
}