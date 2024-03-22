package com.aura.organizationapi.domain.service;

import com.aura.organizationapi.app.api.dto.JobPositionFormDTO;
import com.aura.organizationapi.app.api.mapper.JobPositionMapper;
import com.aura.organizationapi.domain.model.JobPosition;
import com.aura.organizationapi.domain.repository.JobPositionRepository;
import com.aura.organizationapi.domain.util.exception.JobPositionNotFoundException;
import com.aura.organizationapi.domain.util.filter.JobPositionFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class JobPositionService {

    private final JobPositionRepository jobPositionRepository;

    public Page<JobPosition> findAll(Pageable pageable, JobPositionFilter filter) {
        return jobPositionRepository.findAll(pageable, filter);
    }

    public JobPosition findById(UUID id) {
        return jobPositionRepository.findById(id)
                .orElseThrow(() -> new JobPositionNotFoundException(id));
    }

    public JobPosition create(JobPositionFormDTO jobPositionFormDTO) {
        JobPosition jobPosition = JobPositionMapper.toJobPosition(jobPositionFormDTO);
        return jobPositionRepository.create(jobPosition);
    }

    public JobPosition update(UUID id, JobPositionFormDTO jobPositionFormDTO) {
        JobPosition oldJobPosition = findById(id);
        JobPosition jobPosition = JobPositionMapper.toJobPosition(oldJobPosition, jobPositionFormDTO);
        return jobPositionRepository.update(jobPosition);
    }

    public void deleteById(UUID id) {
        jobPositionRepository.deleteById(id);
    }

}
