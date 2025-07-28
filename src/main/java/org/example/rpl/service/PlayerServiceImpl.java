package org.example.rpl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.rpl.dto.player.PlayerRequestDTO;
import org.example.rpl.dto.player.PlayerResponseDTO;
import org.example.rpl.entity.Player;
import org.example.rpl.kafka.KafkaProducer;
import org.example.rpl.kafka.PlayerEvents;
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
    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;

    @Override
    public PlayerResponseDTO createPlayer(PlayerRequestDTO playerDTO) {
        Player player = playerMapper.toEntity(playerDTO);
        Player savedPlayer = playerRepository.save(player);
        
        // Отправляем событие создания в Kafka
        try {
            String eventMessage = objectMapper.writeValueAsString(playerDTO);
            kafkaProducer.sendMessage("player-created-topic", eventMessage);
            System.out.println("Player creation event sent to Kafka: " + eventMessage);
        } catch (JsonProcessingException e) {
            System.err.println("Error serializing player creation event: " + e.getMessage());
        }
        
        return playerMapper.toResponseDTO(savedPlayer);
    }

    // Метод для создания игрока из Kafka события (без отправки события обратно)
    public PlayerResponseDTO createPlayerFromEvent(PlayerRequestDTO playerDTO) {
        Player player = playerMapper.toEntity(playerDTO);
        Player savedPlayer = playerRepository.save(player);
        System.out.println("Player created from Kafka event: " + savedPlayer.getName());
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
        
        // Отправляем событие обновления в Kafka
        try {
            PlayerEvents.PlayerUpdateEvent updateEvent = 
                new PlayerEvents.PlayerUpdateEvent(id, playerDTO);
            String eventMessage = objectMapper.writeValueAsString(updateEvent);
            kafkaProducer.sendMessage("player-updated-topic", eventMessage);
            System.out.println("Player update event sent to Kafka: " + eventMessage);
        } catch (JsonProcessingException e) {
            System.err.println("Error serializing player update event: " + e.getMessage());
        }
        
        return playerMapper.toResponseDTO(updatedPlayer);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
        
        // Отправляем событие удаления в Kafka
        try {
            PlayerEvents.PlayerDeleteEvent deleteEvent = 
                new PlayerEvents.PlayerDeleteEvent(id);
            String eventMessage = objectMapper.writeValueAsString(deleteEvent);
            kafkaProducer.sendMessage("player-deleted-topic", eventMessage);
            System.out.println("Player deletion event sent to Kafka: " + eventMessage);
        } catch (JsonProcessingException e) {
            System.err.println("Error serializing player deletion event: " + e.getMessage());
        }
    }
}