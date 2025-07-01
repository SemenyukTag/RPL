package org.example.rpl.mapper;

import org.example.rpl.dto.player.SimplePlayerResponseDTO;
import org.example.rpl.dto.team.TeamRequestDTO;
import org.example.rpl.dto.team.TeamResponseDTO;
import org.example.rpl.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        List<SimplePlayerResponseDTO> players = null;
        if (team.getPlayers() != null) {
            players = team.getPlayers().stream()
                    .map(player -> SimplePlayerResponseDTO.builder()
                            .id(player.getId())
                            .name(player.getName())
                            .rating(player.getRating())
                            .position(player.getPosition())
                            .age(player.getAge())
                            .status(player.getStatus())
                            .build())
                    .collect(Collectors.toList());
        }

        return TeamResponseDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .city(team.getCity())
                .rating(team.getRating())
                .players(players)
                .createdAt(team.getCreatedAt())
                .updatedAt(team.getUpdatedAt())
                .build();
    }
}