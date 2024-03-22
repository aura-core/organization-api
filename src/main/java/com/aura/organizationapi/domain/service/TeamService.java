package com.aura.organizationapi.domain.service;

import com.aura.organizationapi.app.api.dto.TeamDTO;
import com.aura.organizationapi.app.api.dto.TeamFormDTO;
import com.aura.organizationapi.app.api.mapper.SectorMapper;
import com.aura.organizationapi.app.api.mapper.TeamMapper;
import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.repository.SectorRepository;
import com.aura.organizationapi.domain.repository.TeamRepository;
import com.aura.organizationapi.domain.util.exception.SectorNotFoundException;
import com.aura.organizationapi.domain.util.exception.TeamNotFoundException;
import com.aura.organizationapi.domain.util.filter.SectorFilter;
import com.aura.organizationapi.domain.util.filter.TeamFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final UserService userService;

    public Page<Team> findAll(Pageable pageable, TeamFilter filter) {
        return teamRepository.findAll(pageable, filter);
    }

    public Team findById(UUID id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }

    public Team create(TeamFormDTO teamFormDTO) {
        User responsible = userService.findById(teamFormDTO.responsibleId());
        Team team = TeamMapper.toTeam(teamFormDTO, responsible);
        return teamRepository.create(team);
    }

    public Team update(UUID id, TeamFormDTO teamFormDTO) {
        Team oldTeam = findById(id);
        User responsible = userService.findById(teamFormDTO.responsibleId());
        Team team = TeamMapper.toTeam(oldTeam, teamFormDTO, responsible);
        return teamRepository.update(team);
    }

    public void deleteById(UUID id) {
        teamRepository.deleteById(id);
    }

}
