package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.commons.RoleDto2;
import com.aura.organizationapi.domain.model.commons.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    Role toRole(RoleDto2 dto);

    RoleDto2 toRoleDTO(Role role);

    default Set<Role> toRole(Set<RoleDto2> dtos) {
        return dtos.stream()
                .map(this::toRole)
                .collect(Collectors.toSet());
    }

    default Set<RoleDto2> toRoleDTO(Set<Role> roles) {
        return roles.stream()
                .map(this::toRoleDTO)
                .collect(Collectors.toSet());
    }

}
