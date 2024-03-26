package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.UnitDTO;
import com.aura.organizationapi.app.api.dto.UnitFormDTO;
import com.aura.organizationapi.domain.mapper.UnitMapper;
import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.service.UnitService;
import com.aura.organizationapi.domain.util.filter.UnitFilter;
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
@RequestMapping("/api/v1/units")
public class UnitController {

    private final UnitService unitService;
    private final UnitMapper unitMapper;

    @GetMapping
    public ResponseEntity<Page<UnitDTO>> findAll(@PageableDefault Pageable page,
                                                 @RequestParam(required = false) UnitFilter filter) {
        Page<Unit> units = unitService.findAll(page, filter);
        Page<UnitDTO> unitsDTO = units.map(unitMapper::toUnitDTO);
        return ResponseEntity.ok(unitsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDTO> findById(@PathVariable UUID id) {
        Unit unit = unitService.findById(id);
        UnitDTO dto = unitMapper.toUnitDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UnitDTO> create(@RequestBody @Valid UnitFormDTO form) {
        Unit unit = unitService.create(form);
        UnitDTO dto = unitMapper.toUnitDTO(unit);
        return ResponseEntity.created(URI.create("/api/v1/units/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitDTO> update(@PathVariable UUID id, @RequestBody @Valid UnitFormDTO form) {
        Unit unit = unitService.update(id, form);
        UnitDTO dto = unitMapper.toUnitDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<UnitDTO> inactivate(@PathVariable UUID id) {
        Unit unit = unitService.inactivate(id);
        UnitDTO dto = unitMapper.toUnitDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<UnitDTO> logicallyDelete(@PathVariable UUID id) {
        Unit unit = unitService.logicallyDelete(id);
        UnitDTO dto = unitMapper.toUnitDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        unitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
