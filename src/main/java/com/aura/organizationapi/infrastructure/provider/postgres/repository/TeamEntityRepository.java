package com.aura.organizationapi.infrastructure.provider.postgres.repository;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface TeamEntityRepository extends JpaRepository<TeamEntity, UUID>, JpaSpecificationExecutor<TeamEntity> {
}
