package org.example.rpl.controller;

import lombok.RequiredArgsConstructor;
import org.example.rpl.entity.Player;
import org.example.rpl.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/new")
    public Player newPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping("/all")
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Integer id) {
        return playerService.findById(id);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Integer id, @RequestBody Player player) {
        return playerService.updatePlayer(player, id);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }



    }

