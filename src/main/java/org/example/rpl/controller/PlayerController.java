package org.example.rpl.controller;

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
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("new")
    public PlayerResponseDTO createPlayer(@RequestBody @Valid PlayerRequestDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }

    @GetMapping("all")
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