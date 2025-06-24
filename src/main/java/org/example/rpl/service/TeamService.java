package org.example.rpl.service;

import org.example.rpl.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAll();
    Team findById(Integer id);
    Team save(Team team);
    void delete(Integer id);
    Team update(Team team);
}