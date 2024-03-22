package com.aura.organizationapi.infrastructure.adapter.mapper;

import com.aura.organizationapi.domain.model.Department;
import com.aura.organizationapi.domain.util.filter.DepartmentFilter;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.DepartmentEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.specification.DepartmentSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DepartmentEntityMapper {

    public static DepartmentEntity toDepartmentEntity(Department department) {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setId(department.getId());
        entity.setName(department.getName());
        entity.setContact(ContactEntityMapper.toContactEntity(department.getContact()));
        entity.setDescription(department.getDescription());
        entity.setUpdatedAt(department.getUpdatedAt());
        entity.setCreatedAt(department.getCreatedAt());
        entity.setStatus(map(department.getStatus()));
        entity.setResponsible(UserEntityMapper.toUserEntity(department.getResponsible()));
        return entity;
    }

    public static Department toDepartment(DepartmentEntity entity) {
        Department department = new Department();
        department.setId(entity.getId());
        department.setName(entity.getName());
        department.setContact(ContactEntityMapper.toContact(entity.getContact()));
        department.setDescription(entity.getDescription());
        department.setUpdatedAt(entity.getUpdatedAt());
        department.setCreatedAt(entity.getCreatedAt());
        department.setStatus(map(entity.getStatus()));
        department.setResponsible(UserEntityMapper.toUser(entity.getResponsible()));
        return department;
    }

    public static DepartmentSpecification map(DepartmentFilter departmentFilter) {
        if (departmentFilter == null) {
            return null;
        }
        DepartmentSpecification specification = new DepartmentSpecification();
        specification.setName(departmentFilter.name());
        specification.setStatus(map(departmentFilter.status()));
        specification.setResponsibleId(departmentFilter.responsible().id());
        specification.setResponsibleName(departmentFilter.responsible().name());
        return specification;
    }

    private static DepartmentEntity.Status map(Department.Status status) {
        if (status == null) {
            return null;
        }
        return DepartmentEntity.Status.valueOf(status.name());
    }

    private static Department.Status map(DepartmentEntity.Status status) {
        if (status == null) {
            return null;
        }
        return Department.Status.valueOf(status.name());
    }

}
