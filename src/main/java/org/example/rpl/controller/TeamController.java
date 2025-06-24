package org.example.rpl.controller;

import lombok.RequiredArgsConstructor;
import org.example.rpl.entity.Player;
import org.example.rpl.entity.Team;
import org.example.rpl.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/new")
    public Team createTeam(@RequestBody Team team) {
        return teamService.save(team);
    }

    
    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Integer id) {
        return teamService.findById(id);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Integer id, @RequestBody Team team) {
        return teamService.update(team, id);
    }


    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Integer id) {
        teamService.delete(id);
    }
}
