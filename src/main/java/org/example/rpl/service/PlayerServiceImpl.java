package org.example.rpl.service;

import lombok.RequiredArgsConstructor;
import org.example.rpl.dto.player.PlayerRequestDTO;
import org.example.rpl.dto.player.PlayerResponseDTO;
import org.example.rpl.entity.Player;
import org.example.rpl.mapper.PlayerMapper;
import org.example.rpl.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerResponseDTO createPlayer(PlayerRequestDTO playerDTO) {
        Player player = playerMapper.toEntity(playerDTO);
        Player savedPlayer = playerRepository.save(player);
        return playerMapper.toResponseDTO(savedPlayer);
    }

    @Override
    public List<PlayerResponseDTO> findAll() {
        return playerRepository.findAll().stream()
                .map(playerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerResponseDTO findById(Integer id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        return playerMapper.toResponseDTO(player);
    }

    @Override
    public PlayerResponseDTO updatePlayer(PlayerRequestDTO playerDTO, Integer id) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        playerMapper.updateEntity(playerDTO, existingPlayer);
        Player updatedPlayer = playerRepository.save(existingPlayer);
        return playerMapper.toResponseDTO(updatedPlayer);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }
}