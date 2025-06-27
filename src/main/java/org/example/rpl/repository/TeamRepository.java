package org.example.rpl.repository;

import org.example.rpl.entity.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @EntityGraph(attributePaths = {"teams"})
    Optional<Team> findWithTeamsById(Integer id);

    Integer id(int id);
}
