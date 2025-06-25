package org.example.rpl.service;

import org.example.rpl.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAll();
    Team findById(Integer id);
    Team createTeam(Team team);
    void deleteTeam(Integer id);
    Team updateteam(Team team);
}