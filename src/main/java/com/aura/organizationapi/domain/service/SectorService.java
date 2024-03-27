package com.aura.organizationapi.domain.service;

import com.aura.organizationapi.app.api.dto.SectorFormDto;
import com.aura.organizationapi.domain.mapper.SectorMapper;
import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.repository.SectorRepository;
import com.aura.organizationapi.domain.util.exception.SectorNotFoundException;
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
    private final SectorMapper sectorMapper;

    public Page<Sector> findAll(Pageable pageable, SectorFilter filter) {
        return sectorRepository.findAll(pageable, filter);
    }

    public Sector findById(UUID id) {
        return sectorRepository.findById(id)
                .orElseThrow(() -> new SectorNotFoundException(id));
    }

    public Sector create(SectorFormDto sectorFormDTO) {
        User responsible = userService.findById(sectorFormDTO.responsibleId());
        Sector sector = sectorMapper.toSector(sectorFormDTO, responsible);
        return sectorRepository.create(sector);
    }

    public Sector update(UUID id, SectorFormDto sectorFormDTO) {
        Sector sector = findById(id);
        User responsible = userService.findById(sectorFormDTO.responsibleId());
        sectorMapper.updateSectorFromDTO(sector, sectorFormDTO, responsible);
        return sectorRepository.update(sector);
    }

    public Sector inactivate(UUID id) {
        Sector sector = findById(id);
        sector.setStatus(Sector.Status.INACTIVE);
        return sectorRepository.update(sector);
    }

    public Sector logicallyDelete(UUID id) {
        Sector sector = findById(id);
        sector.setStatus(Sector.Status.DELETED);
        return sectorRepository.update(sector);
    }

    public void deleteById(UUID id) {
        sectorRepository.deleteById(id);
    }

}
