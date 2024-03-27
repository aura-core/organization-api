package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.JobPositionDto;
import com.aura.organizationapi.app.api.dto.JobPositionFormDto;
import com.aura.organizationapi.domain.model.JobPosition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobPositionMapper {

    JobPosition toJobPosition(JobPositionFormDto jobPositionFormDTO);

    void updateJobPositionFromDTO(@MappingTarget JobPosition jobPosition, JobPositionFormDto jobPositionFormDTO);

    JobPositionDto toJobPositionDTO(JobPosition jobPosition);

}
