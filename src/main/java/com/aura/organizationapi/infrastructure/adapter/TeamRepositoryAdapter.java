package com.aura.organizationapi.infrastructure.adapter;

import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.repository.TeamRepository;
import com.aura.organizationapi.domain.util.filter.TeamFilter;
import com.aura.organizationapi.infrastructure.adapter.mapper.TeamEntityMapper;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.TeamEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.repository.TeamEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class TeamRepositoryAdapter implements TeamRepository {

    private final TeamEntityRepository teamEntityRepository;

    @Override
    public Page<Team> findAll(Pageable pageable, TeamFilter filter) {
        return teamEntityRepository.findAll(TeamEntityMapper.map(filter), pageable)
                .map(TeamEntityMapper::toTeam);
    }

    @Override
    public Optional<Team> findById(UUID id) {
        return teamEntityRepository.findById(id)
                .map(TeamEntityMapper::toTeam);
    }

    @Override
    public Team create(Team team) {
        TeamEntity entity = TeamEntityMapper.toTeamEntity(team);
        entity = teamEntityRepository.save(entity);
        return TeamEntityMapper.toTeam(entity);
    }

    @Override
    public Team update(Team team) {
        TeamEntity entity = TeamEntityMapper.toTeamEntity(team);
        entity = teamEntityRepository.save(entity);
        return TeamEntityMapper.toTeam(entity);
    }

    @Override
    public void deleteById(UUID id) {
        teamEntityRepository.deleteById(id);
    }

}
