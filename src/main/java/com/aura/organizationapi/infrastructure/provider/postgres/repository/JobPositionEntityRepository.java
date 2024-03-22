package com.aura.organizationapi.infrastructure.provider.postgres.repository;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.JobPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface JobPositionEntityRepository extends JpaRepository<JobPositionEntity, UUID>, JpaSpecificationExecutor<JobPositionEntity> {
}
