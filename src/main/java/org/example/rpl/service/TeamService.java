package org.example.rpl.service;

import org.example.rpl.dto.team.TeamRequestDTO;
import org.example.rpl.dto.team.TeamResponseDTO;
import org.example.rpl.entity.Team;

import java.util.List;

public interface TeamService {
    List<TeamResponseDTO> findAll();
    TeamResponseDTO findById(Integer id);
    TeamResponseDTO createTeam(TeamRequestDTO teamDTO);
    void deleteTeam(Integer id);
    TeamResponseDTO updateTeam(TeamRequestDTO teamDTO, Integer id);
}