package org.example.rpl.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.rpl.dto.PlayerRequestDTO;
import org.example.rpl.dto.PlayerResponseDTO;
import org.example.rpl.dto.PlayerStatusDTO;
import org.example.rpl.entity.Player;
import org.example.rpl.mapper.PlayerMapper;
import org.example.rpl.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping
    public PlayerResponseDTO createPlayer(@RequestBody @Valid PlayerRequestDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }

    @GetMapping
    public List<PlayerResponseDTO> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public PlayerResponseDTO getPlayer(@PathVariable Integer id) {
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