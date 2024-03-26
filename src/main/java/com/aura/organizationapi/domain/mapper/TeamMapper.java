package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.TeamDTO;
import com.aura.organizationapi.app.api.dto.TeamFormDTO;
import com.aura.organizationapi.app.api.dto.UnitDTO;
import com.aura.organizationapi.app.api.dto.UnitFormDTO;
import com.aura.organizationapi.domain.mapper.commons.ContactMapper;
import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.model.User;
import lombok.experimental.UtilityClass;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {

    Team toTeam(TeamFormDTO teamFormDTO);

    default Team toTeam(TeamFormDTO teamFormDTO, User responsible) {
        if (teamFormDTO == null) {
            return null;
        }
        Team team = toTeam(teamFormDTO);
        team.setResponsible(responsible);
        return team;
    }

    void updateTeamFromDTO(@MappingTarget Team team, TeamFormDTO teamFormDTO);

    default void updateTeamFromDTO(@MappingTarget Team team, TeamFormDTO teamFormDTO, User responsible) {
        if (team == null) {
            return;
        }
        updateTeamFromDTO(team, teamFormDTO);
        team.setResponsible(responsible);
    }

    TeamDTO toTeamDTO(Team team);

}
