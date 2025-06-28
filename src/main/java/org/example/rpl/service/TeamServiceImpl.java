package org.example.rpl.service;

import lombok.RequiredArgsConstructor;
import org.example.rpl.dto.team.TeamRequestDTO;
import org.example.rpl.dto.team.TeamResponseDTO;
import org.example.rpl.entity.Team;
import org.example.rpl.mapper.TeamMapper;
import org.example.rpl.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public List<TeamResponseDTO> findAll() {
        return teamRepository.findAll().stream()
                .map(teamMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeamResponseDTO findById(Integer id) {
        return teamRepository.findById(id)
                .map(teamMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    @Override
    public TeamResponseDTO createTeam(TeamRequestDTO teamDTO) {
        Team team = teamMapper.toEntity(teamDTO);
        Team savedTeam = teamRepository.save(team);
        return teamMapper.toResponseDTO(savedTeam);
    }

    @Override
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

    @Override
    public TeamResponseDTO updateTeam(TeamRequestDTO teamDTO, Integer id) {
        return teamRepository.findById(id)
                .map(existingTeam -> {
                    existingTeam.setName(teamDTO.getName());
                    existingTeam.setCity(teamDTO.getCity());
                    existingTeam.setRating(teamDTO.getRating());
                    Team updatedTeam = teamRepository.save(existingTeam);
                    return teamMapper.toResponseDTO(updatedTeam);
                })
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + id));
    }
}