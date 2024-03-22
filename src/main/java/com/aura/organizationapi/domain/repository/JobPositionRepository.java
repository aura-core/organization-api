package com.aura.organizationapi.domain.repository;

import com.aura.organizationapi.domain.model.JobPosition;
import com.aura.organizationapi.domain.util.filter.JobPositionFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface JobPositionRepository {

    Page<JobPosition> findAll(Pageable pageable, JobPositionFilter filter);
    Optional<JobPosition> findById(UUID id);
    JobPosition create(JobPosition jobPosition);
    JobPosition update(JobPosition jobPosition);
    void deleteById(UUID id);

}
