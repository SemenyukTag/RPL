package org.example.rpl.dto.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rpl.dto.player.SimplePlayerResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDTO {
    private Integer id;
    private String name;
    private String city;
    private String rating;
    private List<SimplePlayerResponseDTO> players;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}