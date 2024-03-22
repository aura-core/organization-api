package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.SectorDTO;
import com.aura.organizationapi.app.api.dto.SectorFormDTO;
import com.aura.organizationapi.app.api.mapper.SectorMapper;
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

    @GetMapping
    public ResponseEntity<Page<SectorDTO>> findAll(@PageableDefault Pageable page,
                                                   @RequestParam(required = false) SectorFilter filter) {
        Page<Sector> sectors = sectorService.findAll(page, filter);
        Page<SectorDTO> sectorDTOS = sectors.map(SectorMapper::toSectorDTO);
        return ResponseEntity.ok(sectorDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDTO> findById(@PathVariable UUID id) {
        Sector sector = sectorService.findById(id);
        SectorDTO dto = SectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<SectorDTO> create(@RequestBody @Valid SectorFormDTO form) {
        Sector sector = sectorService.create(form);
        SectorDTO dto = SectorMapper.toSectorDTO(sector);
        return ResponseEntity.created(URI.create("/api/v1/sectors/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorDTO> update(@PathVariable UUID id, @RequestBody @Valid SectorFormDTO form) {
        Sector sector = sectorService.update(id, form);
        SectorDTO dto = SectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<SectorDTO> inactivate(@PathVariable UUID id) {
        //User user = UserMapper.toUser(id, dto);
        //User updatedUser = userService.update(user);
        //UserDTO updateUserDTO = UserMapper.toUserDTO(updatedUser);
        //return ResponseEntity.ok(updateUserDTO);
        return null;
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<SectorDTO> logicallyDelete(@PathVariable UUID id) {
        //User user = UserMapper.toUser(id, dto);
        //User updatedUser = userService.update(user);
        //UserDTO updateUserDTO = UserMapper.toUserDTO(updatedUser);
        //return ResponseEntity.ok(updateUserDTO);
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        sectorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
