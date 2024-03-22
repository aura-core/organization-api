package com.aura.organizationapi.domain.repository;

import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.util.filter.UnitFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UnitRepository {

    Page<Unit> findAll(Pageable pageable, UnitFilter filter);
    Optional<Unit> findById(UUID id);
    Unit create(Unit unit);
    Unit update(Unit unit);
    void deleteById(UUID id);

}
