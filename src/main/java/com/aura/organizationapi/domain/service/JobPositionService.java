package com.aura.organizationapi.domain.service;

import com.aura.organizationapi.app.api.dto.JobPositionFormDto;
import com.aura.organizationapi.domain.mapper.JobPositionMapper;
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
    private final JobPositionMapper jobPositionMapper;

    public Page<JobPosition> findAll(Pageable pageable, JobPositionFilter filter) {
        return jobPositionRepository.findAll(pageable, filter);
    }

    public JobPosition findById(UUID id) {
        return jobPositionRepository.findById(id)
                .orElseThrow(() -> new JobPositionNotFoundException(id));
    }

    public JobPosition create(JobPositionFormDto jobPositionFormDTO) {
        JobPosition jobPosition = jobPositionMapper.toJobPosition(jobPositionFormDTO);
        return jobPositionRepository.create(jobPosition);
    }

    public JobPosition update(UUID id, JobPositionFormDto jobPositionFormDTO) {
        JobPosition jobPosition = findById(id);
        jobPositionMapper.updateJobPositionFromDTO(jobPosition, jobPositionFormDTO);
        return jobPositionRepository.update(jobPosition);
    }

    public JobPosition inactivate(UUID id) {
        JobPosition jobPosition = findById(id);
        jobPosition.setStatus(JobPosition.Status.INACTIVE);
        return jobPositionRepository.update(jobPosition);
    }

    public JobPosition logicallyDelete(UUID id) {
        JobPosition jobPosition = findById(id);
        jobPosition.setStatus(JobPosition.Status.DELETED);
        return jobPositionRepository.update(jobPosition);
    }

    public void deleteById(UUID id) {
        jobPositionRepository.deleteById(id);
    }

}
