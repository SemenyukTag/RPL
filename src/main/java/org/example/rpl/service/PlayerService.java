package org.example.rpl.service;

import org.example.rpl.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAll();
    Player findById(Integer Id);
    Player createPlayer(Player player);
    Player updatePlayer(Player player, Integer Id);
    void deletePlayer(Integer Id);
}
