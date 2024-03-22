package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.TeamDTO;
import com.aura.organizationapi.app.api.dto.TeamFormDTO;
import com.aura.organizationapi.app.api.mapper.commons.ContactMapper;
import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeamMapper {

    public static Team toTeam(TeamFormDTO teamFormDTO, User responsible) {
        Team team = new Team();
        team.setName(teamFormDTO.name());
        team.setDescription(teamFormDTO.description());
        team.setResponsible(responsible);
        team.setContact(ContactMapper.toContact(teamFormDTO.contact()));
        return team;
    }

    public static Team toTeam(Team oldTeam, TeamFormDTO teamFormDTO, User responsible) {
        oldTeam.setName(teamFormDTO.name());
        oldTeam.setDescription(teamFormDTO.description());
        oldTeam.setResponsible(responsible);
        oldTeam.setContact(ContactMapper.toContact(teamFormDTO.contact()));
        return oldTeam;
    }

    public static TeamDTO toTeamDTO(Team team) {
        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getDescription(),
                UserMapper.toUserDTO(team.getResponsible()),
                ContactMapper.toContactDTO(team.getContact()),
                map(team.getStatus())
        );
    }

    public static TeamDTO.Status map(Team.Status status) {
        return TeamDTO.Status.valueOf(status.name());
    }

}
