package com.aura.organizationapi.app.api.mapper.commons;

import com.aura.organizationapi.app.api.dto.commons.RoleDTO;
import com.aura.organizationapi.domain.model.commons.Role;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class RoleMapper {

    public Role toRole(RoleDTO dto) {
        return Role.valueOf(dto.name());
    }

    public RoleDTO toRoleDTO(Role role) {
        return RoleDTO.valueOf(role.name());
    }

    public Set<Role> toRole(Set<RoleDTO> dtos) {
        return dtos.stream()
                .map(RoleMapper::toRole)
                .collect(Collectors.toSet());
    }

    public Set<RoleDTO> toRoleDTO(Set<Role> roles) {
        return roles.stream()
                .map(RoleMapper::toRoleDTO)
                .collect(Collectors.toSet());
    }

}
