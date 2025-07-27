package org.example.rpl.dto.player;

import jakarta.validation.constraints.NotNull;
import org.example.rpl.entity.Player.PlayerStatus;

public class PlayerRequestDTO {
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Rating cannot be null")
    private int rating;

    @NotNull(message = "Position cannot be null")
    private String position;

    @NotNull(message = "Age cannot be null")
    private int age;

    @NotNull(message = "Status cannot be null")
    private PlayerStatus status;

    // Конструкторы
    public PlayerRequestDTO() {}

    public PlayerRequestDTO(String name, int rating, String position, int age, PlayerStatus status) {
        this.name = name;
        this.rating = rating;
        this.position = position;
        this.age = age;
        this.status = status;
    }

    // Геттеры
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

    // Сеттеры
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
}