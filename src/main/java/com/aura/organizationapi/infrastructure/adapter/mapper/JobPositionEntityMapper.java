package com.aura.organizationapi.infrastructure.adapter.mapper;

import com.aura.organizationapi.domain.model.JobPosition;
import com.aura.organizationapi.domain.model.commons.Role;
import com.aura.organizationapi.domain.util.filter.JobPositionFilter;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.JobPositionEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.specification.JobPositionSpecification;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class JobPositionEntityMapper {

    public static JobPositionEntity toJobPositionEntity(JobPosition jobPosition) {
        JobPositionEntity entity = new JobPositionEntity();
        entity.setId(jobPosition.getId());
        entity.setName(jobPosition.getName());
        entity.setDescription(jobPosition.getDescription());
        entity.setUpdatedAt(jobPosition.getUpdatedAt());
        entity.setCreatedAt(jobPosition.getCreatedAt());
        entity.setStatus(map(jobPosition.getStatus()));
        Set<String> roles = jobPosition.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        entity.setRoles(roles);
        return entity;
    }

    public static JobPosition toJobPosition(JobPositionEntity entity) {
        JobPosition jobPosition = new JobPosition();
        jobPosition.setId(entity.getId());
        jobPosition.setName(entity.getName());
        jobPosition.setDescription(entity.getDescription());
        jobPosition.setUpdatedAt(entity.getUpdatedAt());
        jobPosition.setCreatedAt(entity.getCreatedAt());
        jobPosition.setStatus(map(entity.getStatus()));
        Set<Role> roles = entity.getRoles().stream().map(roleName -> Role.valueOf(roleName)).collect(Collectors.toSet());
        jobPosition.setRoles(roles);
        return jobPosition;
    }

    public static JobPositionSpecification map(JobPositionFilter jobPositionFilter) {
        if (jobPositionFilter == null) {
            return null;
        }
        JobPositionSpecification specification = new JobPositionSpecification();
        specification.setName(jobPositionFilter.name());
        specification.setStatus(map(jobPositionFilter.status()));
        return specification;
    }

    private static JobPositionEntity.Status map(JobPosition.Status status) {
        if (status == null) {
            return null;
        }
        return JobPositionEntity.Status.valueOf(status.name());
    }

    private static JobPosition.Status map(JobPositionEntity.Status status) {
        if (status == null) {
            return null;
        }
        return JobPosition.Status.valueOf(status.name());
    }

}
