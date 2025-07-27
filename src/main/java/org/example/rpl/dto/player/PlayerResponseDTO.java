package org.example.rpl.dto.player;

import org.example.rpl.dto.team.SimpleTeamResponseDTO;
import org.example.rpl.entity.Player.PlayerStatus;

import java.time.LocalDateTime;

public class PlayerResponseDTO {
    private int id;
    private String name;
    private int rating;
    private String position;
    private int age;
    private PlayerStatus status;
    private SimpleTeamResponseDTO team;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Конструкторы
    public PlayerResponseDTO() {}

    public PlayerResponseDTO(int id, String name, int rating, String position, int age, 
                           PlayerStatus status, SimpleTeamResponseDTO team, 
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.position = position;
        this.age = age;
        this.status = status;
        this.team = team;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public SimpleTeamResponseDTO getTeam() {
        return team;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public void setTeam(SimpleTeamResponseDTO team) {
        this.team = team;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}