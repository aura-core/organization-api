package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.JobPositionDTO;
import com.aura.organizationapi.app.api.dto.JobPositionFormDTO;
import com.aura.organizationapi.app.api.mapper.commons.RoleMapper;
import com.aura.organizationapi.domain.model.JobPosition;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JobPositionMapper {

    public static JobPosition toJobPosition(JobPositionFormDTO jobPositionFormDTO) {
        JobPosition jobPosition = new JobPosition();
        jobPosition.setName(jobPositionFormDTO.name());
        jobPosition.setDescription(jobPositionFormDTO.description());
        jobPosition.setRoles(RoleMapper.toRole(jobPositionFormDTO.roles()));
        return jobPosition;
    }

    public static JobPosition toJobPosition(JobPosition oldJobPosition, JobPositionFormDTO jobPositionFormDTO) {
        oldJobPosition.setName(jobPositionFormDTO.name());
        oldJobPosition.setDescription(jobPositionFormDTO.description());
        oldJobPosition.setRoles(RoleMapper.toRole(jobPositionFormDTO.roles()));
        return oldJobPosition;
    }

    public static JobPositionDTO toJobPositionDTO(JobPosition jobPosition) {
        return new JobPositionDTO(
            jobPosition.getId(),
            jobPosition.getName(),
            jobPosition.getDescription(),
            RoleMapper.toRoleDTO(jobPosition.getRoles()),
            map(jobPosition.getStatus())
        );
    }

    private static JobPositionDTO.Status map(JobPosition.Status status) {
        return JobPositionDTO.Status.valueOf(status.name());
    }

}
