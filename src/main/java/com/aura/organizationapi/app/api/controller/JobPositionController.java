package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.JobPositionDto;
import com.aura.organizationapi.app.api.dto.JobPositionFormDto;
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
    public ResponseEntity<Page<JobPositionDto>> findAll(@PageableDefault Pageable page,
                                                        @RequestParam(required = false) JobPositionFilter filter) {
        Page<JobPosition> jobPositions = jobPositionService.findAll(page, filter);
        Page<JobPositionDto> jobPositionsDTO = jobPositions.map(jobPositionMapper::toJobPositionDTO);
        return ResponseEntity.ok(jobPositionsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPositionDto> findById(@PathVariable UUID id) {
        JobPosition jobPosition = jobPositionService.findById(id);
        JobPositionDto dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<JobPositionDto> create(@RequestBody @Valid JobPositionFormDto form) {
        JobPosition jobPosition = jobPositionService.create(form);
        JobPositionDto dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.created(URI.create("/api/v1/job-positions/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPositionDto> update(@PathVariable UUID id, @RequestBody @Valid JobPositionFormDto form) {
        JobPosition jobPosition = jobPositionService.update(id, form);
        JobPositionDto dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<JobPositionDto> inactivate(@PathVariable UUID id) {
        JobPosition jobPosition = jobPositionService.inactivate(id);
        JobPositionDto dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<JobPositionDto> logicallyDelete(@PathVariable UUID id) {
        JobPosition jobPosition = jobPositionService.logicallyDelete(id);
        JobPositionDto dto = jobPositionMapper.toJobPositionDTO(jobPosition);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        jobPositionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
