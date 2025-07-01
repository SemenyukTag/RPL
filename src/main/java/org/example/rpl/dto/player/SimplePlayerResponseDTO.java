package org.example.rpl.dto.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rpl.entity.Player.PlayerStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplePlayerResponseDTO {
    private int id;
    private String name;
    private int rating;
    private String position;
    private int age;
    private PlayerStatus status;
}