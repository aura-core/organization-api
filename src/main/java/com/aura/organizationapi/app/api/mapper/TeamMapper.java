package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.TeamDTO;
import com.aura.organizationapi.app.api.dto.TeamFormDTO;
import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeamMapper {

    public static Team toTeam(TeamFormDTO teamFormDTO, User responsible) {
        return null;
    }

    public static Team toTeam(Team oldTeam, TeamFormDTO teamFormDTO, User responsible) {
        return null;
    }

    public static TeamDTO toTeamDTO(Team team) {
        return null;
    }

}
