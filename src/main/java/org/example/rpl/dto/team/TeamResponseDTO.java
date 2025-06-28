package org.example.rpl.dto.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDTO {
    private Integer id;
    private String name;
    private String city;
    private String rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}