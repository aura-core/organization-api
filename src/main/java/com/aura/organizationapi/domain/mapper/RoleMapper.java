package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.commons.RoleDto;
import com.aura.organizationapi.domain.model.commons.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    Role toRole(RoleDto dto);

    RoleDto toRoleDTO(Role role);

    default Set<Role> toRole(Set<RoleDto> dtos) {
        return dtos.stream()
                .map(this::toRole)
                .collect(Collectors.toSet());
    }

    default Set<RoleDto> toRoleDTO(Set<Role> roles) {
        return roles.stream()
                .map(this::toRoleDTO)
                .collect(Collectors.toSet());
    }

}
