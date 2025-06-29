package org.example.rpl.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.rpl.dto.team.TeamRequestDTO;
import org.example.rpl.dto.team.TeamResponseDTO;
import org.example.rpl.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("new")
    public TeamResponseDTO createTeam(@RequestBody @Valid TeamRequestDTO teamDTO) {
        return teamService.createTeam(teamDTO);
    }

    @GetMapping("all")
    public List<TeamResponseDTO> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public TeamResponseDTO getTeam(@PathVariable Integer id) {
        return teamService.findById(id);
    }

    @PutMapping("/{id}")
    public TeamResponseDTO updateTeam(
            @PathVariable Integer id,
            @RequestBody @Valid TeamRequestDTO teamDTO) {
        return teamService.updateTeam(teamDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
    }
}