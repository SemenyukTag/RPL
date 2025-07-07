package org.example.rpl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.rpl.dto.player.PlayerRequestDTO;
import org.example.rpl.dto.player.PlayerResponseDTO;
import org.example.rpl.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
@Tag(name = "Управление командами", description = "Методы для работы с футбольными командами")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("new")
    @Operation(summary = "Создать нового игрока",
            description = "Добавляет нового футболиста в систему")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Игрок успешно создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные входные данные"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    public PlayerResponseDTO createPlayer(@RequestBody @Valid PlayerRequestDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }

    @GetMapping("all")
    @Operation(summary = "Получить всех игроков",
            description = "Возвращает список всех футболистов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список игроков успешно получен"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    public List<PlayerResponseDTO> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Найти игрока по ID",
            description = "Возвращает информацию о конкретном футболисте")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Игрок найден"),
            @ApiResponse(responseCode = "404", description = "Игрок не найден"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    public PlayerResponseDTO getPlayer(
            @Parameter(description = "Уникальный идентификатор игрока", required = true, example = "1")
            @PathVariable Integer id) {
        return playerService.findById(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDTO updatePlayer(
            @PathVariable Integer id,
            @RequestBody @Valid PlayerRequestDTO playerDTO) {
        return playerService.updatePlayer(playerDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }
}