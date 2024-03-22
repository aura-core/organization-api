package com.aura.organizationapi.domain.repository;

import com.aura.organizationapi.domain.model.Department;
import com.aura.organizationapi.domain.util.filter.DepartmentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface DepartmentRepository {

    Page<Department> findAll(Pageable pageable, DepartmentFilter filter);
    Optional<Department> findById(UUID id);
    Department create(Department department);
    Department update(Department department);
    void deleteById(UUID id);

}
