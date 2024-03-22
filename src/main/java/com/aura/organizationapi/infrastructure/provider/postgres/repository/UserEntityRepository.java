package com.aura.organizationapi.infrastructure.provider.postgres.repository;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID>, JpaSpecificationExecutor<UserEntity> {
}
