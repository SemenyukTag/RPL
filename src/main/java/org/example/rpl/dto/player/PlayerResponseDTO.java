package org.example.rpl.dto.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rpl.entity.Player.PlayerStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerResponseDTO {
    private int id;
    private String name;
    private int rating;
    private String position;
    private int age;
    private PlayerStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}