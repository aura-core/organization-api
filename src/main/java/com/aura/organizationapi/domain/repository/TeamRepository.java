package com.aura.organizationapi.domain.repository;

import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.util.filter.TeamFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface TeamRepository {

    Page<Team> findAll(Pageable pageable, TeamFilter filter);
    Optional<Team> findById(UUID id);
    Team create(Team team);
    Team update(Team team);
    void deleteById(UUID id);

}
