package org.example.rpl.dto.team;

public class SimpleTeamResponseDTO {
    private Integer id;
    private String name;
    private String city;
    private String rating;

    // Конструкторы
    public SimpleTeamResponseDTO() {}

    public SimpleTeamResponseDTO(Integer id, String name, String city, String rating) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

    // Геттеры
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getRating() {
        return rating;
    }

    // Сеттеры
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}