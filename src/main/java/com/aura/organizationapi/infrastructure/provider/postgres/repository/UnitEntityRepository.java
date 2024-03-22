package com.aura.organizationapi.infrastructure.provider.postgres.repository;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UnitEntityRepository extends JpaRepository<UnitEntity, UUID>, JpaSpecificationExecutor<UnitEntity> {
}
