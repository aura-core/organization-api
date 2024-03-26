package com.aura.organizationapi.domain.mapper.commons;

import com.aura.organizationapi.app.api.dto.commons.RoleDTO;
import com.aura.organizationapi.domain.model.commons.Role;
import lombok.experimental.UtilityClass;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    Role toRole(RoleDTO dto);

    RoleDTO toRoleDTO(Role role);

    default Set<Role> toRole(Set<RoleDTO> dtos) {
        return dtos.stream()
                .map(this::toRole)
                .collect(Collectors.toSet());
    }

    default Set<RoleDTO> toRoleDTO(Set<Role> roles) {
        return roles.stream()
                .map(this::toRoleDTO)
                .collect(Collectors.toSet());
    }

}
