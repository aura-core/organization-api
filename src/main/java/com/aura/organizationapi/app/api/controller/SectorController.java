package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.SectorDto;
import com.aura.organizationapi.app.api.dto.SectorFormDto;
import com.aura.organizationapi.domain.mapper.SectorMapper;
import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.service.SectorService;
import com.aura.organizationapi.domain.util.filter.SectorFilter;
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
@RequestMapping("/api/v1/sectors")
public class SectorController {

    private final SectorService sectorService;
    private final SectorMapper sectorMapper;

    @GetMapping
    public ResponseEntity<Page<SectorDto>> findAll(@PageableDefault Pageable page,
                                                   @RequestParam(required = false) SectorFilter filter) {
        Page<Sector> sectors = sectorService.findAll(page, filter);
        Page<SectorDto> sectorDTOS = sectors.map(sectorMapper::toSectorDTO);
        return ResponseEntity.ok(sectorDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDto> findById(@PathVariable UUID id) {
        Sector sector = sectorService.findById(id);
        SectorDto dto = sectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<SectorDto> create(@RequestBody @Valid SectorFormDto form) {
        Sector sector = sectorService.create(form);
        SectorDto dto = sectorMapper.toSectorDTO(sector);
        return ResponseEntity.created(URI.create("/api/v1/sectors/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorDto> update(@PathVariable UUID id, @RequestBody @Valid SectorFormDto form) {
        Sector sector = sectorService.update(id, form);
        SectorDto dto = sectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<SectorDto> inactivate(@PathVariable UUID id) {
        Sector sector = sectorService.inactivate(id);
        SectorDto dto = sectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<SectorDto> logicallyDelete(@PathVariable UUID id) {
        Sector sector = sectorService.logicallyDelete(id);
        SectorDto dto = sectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        sectorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
