package com.aura.organizationapi.infrastructure.provider.postgres.repository;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface DepartmentEntityRepository extends JpaRepository<DepartmentEntity, UUID>, JpaSpecificationExecutor<DepartmentEntity> {
}
