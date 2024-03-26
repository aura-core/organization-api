package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.DepartmentDTO;
import com.aura.organizationapi.app.api.dto.DepartmentFormDTO;
import com.aura.organizationapi.domain.model.Department;
import com.aura.organizationapi.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    Department toDepartment(DepartmentFormDTO departmentFormDTO);

    default Department toDepartment(DepartmentFormDTO departmentFormDTO, User responsible) {
        if (departmentFormDTO == null) {
            return null;
        }
        Department department = toDepartment(departmentFormDTO);
        department.setResponsible(responsible);
        return department;
    }

    void updateDepartmentFromDTO(@MappingTarget Department department, DepartmentFormDTO departmentFormDTO);

    default void updateDepartmentFromDTO(@MappingTarget Department department, DepartmentFormDTO departmentFormDTO, User responsible) {
        if (department == null) {
            return;
        }
        updateDepartmentFromDTO(department, departmentFormDTO);
        department.setResponsible(responsible);
    }

    DepartmentDTO toDepartmentDTO(Department department);

}
