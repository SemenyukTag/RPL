package org.example.rpl.repository;

import org.aspectj.apache.bcel.Repository;
import org.example.rpl.entity.Player;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @EntityGraph(attributePaths = {"players"})
    Optional<Player> findWithplayersById(Integer id);
}
