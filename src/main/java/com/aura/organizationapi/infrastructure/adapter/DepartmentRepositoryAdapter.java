package com.aura.organizationapi.infrastructure.adapter;

import com.aura.organizationapi.domain.model.Department;
import com.aura.organizationapi.domain.repository.DepartmentRepository;
import com.aura.organizationapi.domain.util.filter.DepartmentFilter;
import com.aura.organizationapi.infrastructure.adapter.mapper.DepartmentEntityMapper;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.DepartmentEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.repository.DepartmentEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class DepartmentRepositoryAdapter implements DepartmentRepository {

    private final DepartmentEntityRepository departmentEntityRepository;

    @Override
    public Page<Department> findAll(Pageable pageable, DepartmentFilter filter) {
        return departmentEntityRepository.findAll(DepartmentEntityMapper.map(filter), pageable)
                .map(DepartmentEntityMapper::toDepartment);
    }

    @Override
    public Optional<Department> findById(UUID id) {
        return departmentEntityRepository.findById(id)
                .map(DepartmentEntityMapper::toDepartment);
    }

    @Override
    public Department create(Department department) {
        DepartmentEntity entity = DepartmentEntityMapper.toDepartmentEntity(department);
        entity = departmentEntityRepository.save(entity);
        return DepartmentEntityMapper.toDepartment(entity);
    }

    @Override
    public Department update(Department department) {
        DepartmentEntity entity = DepartmentEntityMapper.toDepartmentEntity(department);
        entity = departmentEntityRepository.save(entity);
        return DepartmentEntityMapper.toDepartment(entity);
    }

    @Override
    public void deleteById(UUID id) {
        departmentEntityRepository.deleteById(id);
    }

}
