package com.aura.organizationapi.domain.repository;

import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.util.filter.SectorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface SectorRepository {

    Page<Sector> findAll(Pageable pageable, SectorFilter filter);
    Optional<Sector> findById(UUID id);
    Sector create(Sector sector);
    Sector update(Sector sector);
    void deleteById(UUID id);

}
