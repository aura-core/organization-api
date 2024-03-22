package com.aura.organizationapi.domain.service;

import com.aura.organizationapi.app.api.dto.SectorDTO;
import com.aura.organizationapi.app.api.dto.SectorFormDTO;
import com.aura.organizationapi.app.api.mapper.SectorMapper;
import com.aura.organizationapi.domain.model.Department;
import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.repository.DepartmentRepository;
import com.aura.organizationapi.domain.repository.SectorRepository;
import com.aura.organizationapi.domain.util.exception.DepartmentNotFoundException;
import com.aura.organizationapi.domain.util.exception.SectorNotFoundException;
import com.aura.organizationapi.domain.util.filter.DepartmentFilter;
import com.aura.organizationapi.domain.util.filter.SectorFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class SectorService {

    private final SectorRepository sectorRepository;
    private final UserService userService;

    public Page<Sector> findAll(Pageable pageable, SectorFilter filter) {
        return sectorRepository.findAll(pageable, filter);
    }

    public Sector findById(UUID id) {
        return sectorRepository.findById(id)
                .orElseThrow(() -> new SectorNotFoundException(id));
    }

    public Sector create(SectorFormDTO sectorFormDTO) {
        User responsible = userService.findById(sectorFormDTO.responsibleId());
        Sector sector = SectorMapper.toSector(sectorFormDTO, responsible);
        return sectorRepository.create(sector);
    }

    public Sector update(UUID id, SectorFormDTO sectorFormDTO) {
        Sector oldSector = findById(id);
        User responsible = userService.findById(sectorFormDTO.responsibleId());
        Sector sector = SectorMapper.toSector(oldSector, sectorFormDTO, responsible);
        return sectorRepository.update(sector);
    }

    public void deleteById(UUID id) {
        sectorRepository.deleteById(id);
    }

}
