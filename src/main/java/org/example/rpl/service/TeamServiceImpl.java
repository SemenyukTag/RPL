package org.example.rpl.service;

import lombok.RequiredArgsConstructor;
import org.example.rpl.entity.Team;
import org.example.rpl.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Integer id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team updateteam(Team team) {
        return teamRepository.findById(team.getId())
                .map(existingTeam -> {
                    existingTeam.setName(team.getName());
                    return teamRepository.save(existingTeam);
                })
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + team.getId()));
    }
}