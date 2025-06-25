package org.example.rpl.service;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.example.rpl.entity.Team;
import org.example.rpl.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    @Override
    public List<Team> findAll() {return teamRepository.findAll();
    }
    @Override
    public Team findById(Integer id) {return teamRepository.findById(id).orElse(null);
    }

    @Override
    public Team creadeTeam(Team team) {return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepository.findById(Id);
                    .map(existingPlayer -> {
                existingPlayer.setName(player.getName());
                existingPlayer.setRating(player.getRating());
                existingPlayer.setCity(player.getCity());
                return playerRepository.save(existingPlayer);
            })
            .orElseThrow(() -> new RuntimeException("Player not found with id: " + Id));

    }

}
