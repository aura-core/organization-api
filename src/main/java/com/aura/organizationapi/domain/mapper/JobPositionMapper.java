package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.JobPositionDTO;
import com.aura.organizationapi.app.api.dto.JobPositionFormDTO;
import com.aura.organizationapi.app.api.dto.SectorFormDTO;
import com.aura.organizationapi.domain.model.JobPosition;
import com.aura.organizationapi.domain.model.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobPositionMapper {

    JobPosition toJobPosition(JobPositionFormDTO jobPositionFormDTO);

    void updateJobPositionFromDTO(@MappingTarget JobPosition jobPosition, JobPositionFormDTO jobPositionFormDTO);

    JobPositionDTO toJobPositionDTO(JobPosition jobPosition);

}
