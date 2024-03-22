package com.aura.organizationapi.infrastructure.adapter;

import com.aura.organizationapi.domain.model.JobPosition;
import com.aura.organizationapi.domain.repository.JobPositionRepository;
import com.aura.organizationapi.domain.util.filter.JobPositionFilter;
import com.aura.organizationapi.infrastructure.adapter.mapper.JobPositionEntityMapper;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.JobPositionEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.repository.JobPositionEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class JobPositionRepositoryAdapter implements JobPositionRepository {

    private final JobPositionEntityRepository jobPositionEntityRepository;

    @Override
    public Page<JobPosition> findAll(Pageable pageable, JobPositionFilter filter) {
        return jobPositionEntityRepository.findAll(JobPositionEntityMapper.map(filter), pageable)
                .map(JobPositionEntityMapper::toJobPosition);
    }

    @Override
    public Optional<JobPosition> findById(UUID id) {
        return jobPositionEntityRepository.findById(id)
                .map(JobPositionEntityMapper::toJobPosition);
    }

    @Override
    public JobPosition create(JobPosition jobPosition) {
        JobPositionEntity entity = JobPositionEntityMapper.toJobPositionEntity(jobPosition);
        entity = jobPositionEntityRepository.save(entity);
        return JobPositionEntityMapper.toJobPosition(entity);
    }

    @Override
    public JobPosition update(JobPosition jobPosition) {
        JobPositionEntity entity = JobPositionEntityMapper.toJobPositionEntity(jobPosition);
        entity = jobPositionEntityRepository.save(entity);
        return JobPositionEntityMapper.toJobPosition(entity);
    }

    @Override
    public void deleteById(UUID id) {
        jobPositionEntityRepository.deleteById(id);
    }

}
