package org.example.rpl.mapper;

import org.example.rpl.dto.team.TeamRequestDTO;
import org.example.rpl.dto.team.TeamResponseDTO;
import org.example.rpl.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {
    public Team toEntity(TeamRequestDTO dto) {
        return Team.builder()
                .name(dto.getName())
                .city(dto.getCity())
                .rating(dto.getRating())
                .build();
    }

    public TeamResponseDTO toResponseDTO(Team team) {
        return TeamResponseDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .city(team.getCity())
                .rating(team.getRating())
                .createdAt(team.getCreatedAt())
                .updatedAt(team.getUpdatedAt())
                .build();
    }
}