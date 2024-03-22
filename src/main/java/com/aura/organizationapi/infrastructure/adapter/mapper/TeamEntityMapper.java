package com.aura.organizationapi.infrastructure.adapter.mapper;

import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.util.filter.TeamFilter;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.TeamEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.specification.TeamSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeamEntityMapper {

    public static TeamEntity toTeamEntity(Team team) {
        TeamEntity entity = new TeamEntity();
        entity.setId(team.getId());
        entity.setName(team.getName());
        entity.setContact(ContactEntityMapper.toContactEntity(team.getContact()));
        entity.setDescription(team.getDescription());
        entity.setUpdatedAt(team.getUpdatedAt());
        entity.setCreatedAt(team.getCreatedAt());
        entity.setStatus(map(team.getStatus()));
        entity.setResponsible(UserEntityMapper.toUserEntity(team.getResponsible()));
        return entity;
    }

    public static Team toTeam(TeamEntity entity) {
        Team team = new Team();
        team.setId(entity.getId());
        team.setName(entity.getName());
        team.setContact(ContactEntityMapper.toContact(entity.getContact()));
        team.setDescription(entity.getDescription());
        team.setUpdatedAt(entity.getUpdatedAt());
        team.setCreatedAt(entity.getCreatedAt());
        team.setStatus(map(entity.getStatus()));
        team.setResponsible(UserEntityMapper.toUser(entity.getResponsible()));
        return team;
    }

    public static TeamSpecification map(TeamFilter teamFilter) {
        if (teamFilter == null) {
            return null;
        }
        TeamSpecification specification = new TeamSpecification();
        specification.setName(teamFilter.name());
        specification.setStatus(map(teamFilter.status()));
        specification.setResponsibleId(teamFilter.responsible().id());
        specification.setResponsibleName(teamFilter.responsible().name());
        return specification;
    }

    private static TeamEntity.Status map(Team.Status status) {
        if (status == null) {
            return null;
        }
        return TeamEntity.Status.valueOf(status.name());
    }

    private static Team.Status map(TeamEntity.Status status) {
        if (status == null) {
            return null;
        }
        return Team.Status.valueOf(status.name());
    }

}
