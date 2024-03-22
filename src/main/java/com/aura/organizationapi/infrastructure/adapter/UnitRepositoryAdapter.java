package com.aura.organizationapi.infrastructure.adapter;

import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.repository.UnitRepository;
import com.aura.organizationapi.domain.util.filter.UnitFilter;
import com.aura.organizationapi.infrastructure.adapter.mapper.UnitEntityMapper;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.UnitEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.repository.UnitEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class UnitRepositoryAdapter implements UnitRepository {

    private final UnitEntityRepository unitEntityRepository;

    @Override
    public Page<Unit> findAll(Pageable pageable, UnitFilter filter) {
        return unitEntityRepository.findAll(UnitEntityMapper.map(filter), pageable)
                .map(UnitEntityMapper::toUnit);
    }

    @Override
    public Optional<Unit> findById(UUID id) {
        return unitEntityRepository.findById(id)
                .map(UnitEntityMapper::toUnit);
    }

    @Override
    public Unit create(Unit unit) {
        UnitEntity entity = UnitEntityMapper.toUnitEntity(unit);
        entity = unitEntityRepository.save(entity);
        return UnitEntityMapper.toUnit(entity);
    }

    @Override
    public Unit update(Unit unit) {
        UnitEntity entity = UnitEntityMapper.toUnitEntity(unit);
        entity = unitEntityRepository.save(entity);
        return UnitEntityMapper.toUnit(entity);
    }

    @Override
    public void deleteById(UUID id) {
        unitEntityRepository.deleteById(id);
    }

}
