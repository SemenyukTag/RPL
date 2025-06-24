package org.example.rpl.service;

import lombok.RequiredArgsConstructor;
import org.example.rpl.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl {
    private final TeamRepository teamRepository;

}
