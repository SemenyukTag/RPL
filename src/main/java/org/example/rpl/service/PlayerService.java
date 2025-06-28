package org.example.rpl.service;

import org.example.rpl.dto.player.PlayerRequestDTO;
import org.example.rpl.dto.player.PlayerResponseDTO;

import java.util.List;

public interface PlayerService {
    PlayerResponseDTO createPlayer(PlayerRequestDTO playerDTO);
    List<PlayerResponseDTO> findAll();
    PlayerResponseDTO findById(Integer id);
    PlayerResponseDTO updatePlayer(PlayerRequestDTO playerDTO, Integer id);
    void deletePlayer(Integer id);
}