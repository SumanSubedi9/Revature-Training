package com.revature.spring.spring_jpa_rest_application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "game_info")

// Lombok annotations to reduce boilerplate code for getters, setters,
// constructors, etc.
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GameInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String platform;
    private double price;

}
