package org.example.rpl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Управление командами", description = "Методы для работы с футбольными командами")
public class TeamController {
    private final TeamService teamService;

    @PostMapping("new")
    @Operation(summary = "Создать новую команду",
            description = "Добавляет новую футбольную команду в систему")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Команда успешно создана"),
            @ApiResponse(responseCode = "400", description = "Некорректные входные данные"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
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