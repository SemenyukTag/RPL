package org.example.rpl.service;

import lombok.RequiredArgsConstructor;
import org.example.rpl.entity.Player;
import org.example.rpl.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(Integer Id) {
        return playerRepository.findById(Id).orElse(null);
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player, Integer Id) {
        return playerRepository.findById(Id)
                .map(existingPlayer -> {
                    existingPlayer.setAge(player.getAge());
                    existingPlayer.setName(player.getName());
                    existingPlayer.setRating(player.getRating());
                    existingPlayer.setPosition(player.getPosition());
                    return playerRepository.save(existingPlayer);
                })
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + Id));
    }

    @Override
    public void deletePlayer(Integer Id) {
        playerRepository.deleteById(Id);
    }
}
