package com.aura.organizationapi.infrastructure.adapter;

import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.repository.SectorRepository;
import com.aura.organizationapi.domain.util.filter.SectorFilter;
import com.aura.organizationapi.infrastructure.adapter.mapper.SectorEntityMapper;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.SectorEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.repository.SectorEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class SectorRepositoryAdapter implements SectorRepository {

    private final SectorEntityRepository sectorEntityRepository;

    @Override
    public Page<Sector> findAll(Pageable pageable, SectorFilter filter) {
        return sectorEntityRepository.findAll(SectorEntityMapper.map(filter), pageable)
                .map(SectorEntityMapper::toSector);
    }

    @Override
    public Optional<Sector> findById(UUID id) {
        return sectorEntityRepository.findById(id)
                .map(SectorEntityMapper::toSector);
    }

    @Override
    public Sector create(Sector sector) {
        SectorEntity entity = SectorEntityMapper.toSectorEntity(sector);
        entity = sectorEntityRepository.save(entity);
        return SectorEntityMapper.toSector(entity);
    }

    @Override
    public Sector update(Sector sector) {
        SectorEntity entity = SectorEntityMapper.toSectorEntity(sector);
        entity = sectorEntityRepository.save(entity);
        return SectorEntityMapper.toSector(entity);
    }

    @Override
    public void deleteById(UUID id) {
        sectorEntityRepository.deleteById(id);
    }

}
