package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.JobPositionDTO;
import com.aura.organizationapi.app.api.dto.JobPositionFormDTO;
import com.aura.organizationapi.app.api.dto.commons.RoleDTO;
import com.aura.organizationapi.domain.mapper.JobPositionMapper;
import com.aura.organizationapi.domain.model.JobPosition;
import com.aura.organizationapi.domain.service.JobPositionService;
import com.aura.organizationapi.domain.util.filter.JobPositionFilter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@Slf4j
@SuppressWarnings("unused")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/job-positions")
public class JobPositionController {

    private final JobPositionService jobPositionService;
    private final JobPositionMapper jobPositionMapper;

    @GetMapping
    public ResponseEntity<Page<JobPositionDTO>> findAll(@PageableDefault Pageable page,
                                                        @RequestParam(required = false) JobPositionFilter filter) {
        Page<JobPosition> jobPositions = jobPositionService.findAll(page, filter);
        Page<JobPositionDTO> jobPositionsDTO = jobPositions.map(jobPositionMapper::toJobPositionDTO);
        return ResponseEntity.ok(jobPositionsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPositionDTO> findById(@PathVariable UUID id) {
        JobPosition jobPosition = jobPositionService.findById(id);
        JobPositionDTO dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<JobPositionDTO> create(@RequestBody @Valid JobPositionFormDTO form) {
        JobPosition jobPosition = jobPositionService.create(form);
        JobPositionDTO dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.created(URI.create("/api/v1/job-positions/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPositionDTO> update(@PathVariable UUID id, @RequestBody @Valid JobPositionFormDTO form) {
        JobPosition jobPosition = jobPositionService.update(id, form);
        JobPositionDTO dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/add-roles/{id}")
    public ResponseEntity<JobPositionDTO> addRoles(@PathVariable UUID id, Set<RoleDTO> roles) {
        //User user = UserMapper.toUser(id, dto);
        //User updatedUser = userService.update(user);
        //UserDTO updateUserDTO = UserMapper.toUserDTO(updatedUser);
        //return ResponseEntity.ok(updateUserDTO);
        return null;
    }

    @PatchMapping("/remove-roles/{id}")
    public ResponseEntity<JobPositionDTO> removeRoles(@PathVariable UUID id, Set<RoleDTO> roles) {
        //User user = UserMapper.toUser(id, dto);
        //User updatedUser = userService.update(user);
        //UserDTO updateUserDTO = UserMapper.toUserDTO(updatedUser);
        //return ResponseEntity.ok(updateUserDTO);
        return null;
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<JobPositionDTO> inactivate(@PathVariable UUID id) {
        JobPosition jobPosition = jobPositionService.inactivate(id);
        JobPositionDTO dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<JobPositionDTO> logicallyDelete(@PathVariable UUID id) {
        JobPosition jobPosition = jobPositionService.logicallyDelete(id);
        JobPositionDTO dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        jobPositionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
