package org.example.rpl.service;

import org.example.rpl.dto.PlayerRequestDTO;
import org.example.rpl.dto.PlayerResponseDTO;

import java.util.List;

public interface PlayerService {
    PlayerResponseDTO createPlayer(PlayerRequestDTO playerDTO);
    List<PlayerResponseDTO> findAll();
    PlayerResponseDTO findById(Integer id);
    PlayerResponseDTO updatePlayer(PlayerRequestDTO playerDTO, Integer id);
    void deletePlayer(Integer id);
}