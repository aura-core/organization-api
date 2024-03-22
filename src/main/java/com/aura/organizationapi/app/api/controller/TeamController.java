package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.TeamDTO;
import com.aura.organizationapi.app.api.dto.TeamFormDTO;
import com.aura.organizationapi.app.api.mapper.TeamMapper;
import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.service.TeamService;
import com.aura.organizationapi.domain.util.filter.TeamFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Slf4j
@SuppressWarnings("unused")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<Page<TeamDTO>> findAll(@PageableDefault Pageable page,
                                                 @RequestParam(required = false) TeamFilter filter) {
        Page<Team> teams = teamService.findAll(page, filter);
        Page<TeamDTO> teamsDTO = teams.map(TeamMapper::toTeamDTO);
        return ResponseEntity.ok(teamsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> findById(@PathVariable UUID id) {
        Team team = teamService.findById(id);
        TeamDTO dto = TeamMapper.toTeamDTO(team);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TeamDTO> create(@RequestBody TeamFormDTO form) {
        Team team = teamService.create(form);
        TeamDTO dto = TeamMapper.toTeamDTO(team);
        return ResponseEntity.created(URI.create("/api/v1/teams/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> update(@PathVariable UUID id, @RequestBody TeamFormDTO form) {
        Team team = teamService.update(id, form);
        TeamDTO dto = TeamMapper.toTeamDTO(team);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<TeamDTO> inactivate(@PathVariable UUID id) {
        //User user = UserMapper.toUser(id, dto);
        //User updatedUser = userService.update(user);
        //UserDTO updateUserDTO = UserMapper.toUserDTO(updatedUser);
        //return ResponseEntity.ok(updateUserDTO);
        return null;
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<TeamDTO> logicallyDelete(@PathVariable UUID id) {
        //User user = UserMapper.toUser(id, dto);
        //User updatedUser = userService.update(user);
        //UserDTO updateUserDTO = UserMapper.toUserDTO(updatedUser);
        //return ResponseEntity.ok(updateUserDTO);
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        teamService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
