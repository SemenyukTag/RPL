package org.example.rpl.mapper;


import org.example.rpl.dto.PlayerRequestDTO;
import org.example.rpl.dto.PlayerResponseDTO;
import org.example.rpl.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public Player toEntity(PlayerRequestDTO dto) {
        return Player.builder()
                .name(dto.getName())
                .rating(dto.getRating())
                .position(dto.getPosition())
                .age(dto.getAge())
                .status(dto.getStatus())
                .build();
    }

    public PlayerResponseDTO toResponseDTO(Player player) {
        return PlayerResponseDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .rating(player.getRating())
                .position(player.getPosition())
                .age(player.getAge())
                .status(player.getStatus())
                .createdAt(player.getCreatedAt())
                .updatedAt(player.getUpdatedAt())
                .build();
    }

    public void updateEntity(PlayerRequestDTO dto, Player entity) {
        entity.setName(dto.getName());
        entity.setRating(dto.getRating());
        entity.setPosition(dto.getPosition());
        entity.setAge(dto.getAge());
        entity.setStatus(dto.getStatus());
    }
}