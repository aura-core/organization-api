package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.DepartmentDTO;
import com.aura.organizationapi.app.api.dto.DepartmentFormDTO;
import com.aura.organizationapi.app.api.mapper.commons.ContactMapper;
import com.aura.organizationapi.domain.model.Department;
import com.aura.organizationapi.domain.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DepartmentMapper {

    public static Department toDepartment(DepartmentFormDTO departmentFormDTO, User responsible) {
        Department department = new Department();
        department.setName(departmentFormDTO.name());
        department.setDescription(departmentFormDTO.description());
        department.setResponsible(responsible);
        department.setContact(ContactMapper.toContact(departmentFormDTO.contact()));
        return department;
    }

    public static Department toDepartment(Department oldDepartment, DepartmentFormDTO departmentFormDTO, User responsible) {
        oldDepartment.setName(departmentFormDTO.name());
        oldDepartment.setDescription(departmentFormDTO.description());
        oldDepartment.setResponsible(responsible);
        oldDepartment.setContact(ContactMapper.toContact(departmentFormDTO.contact()));
        return oldDepartment;
    }

    public static DepartmentDTO toDepartmentDTO(Department department) {
        return new DepartmentDTO(
            department.getId(),
            department.getName(),
            department.getDescription(),
            UserMapper.toUserDTO(department.getResponsible()),
            ContactMapper.toContactDTO(department.getContact()),
            map(department.getStatus())
        );
    }

    private static DepartmentDTO.Status map(Department.Status status) {
        return DepartmentDTO.Status.valueOf(status.name());
    }

}
