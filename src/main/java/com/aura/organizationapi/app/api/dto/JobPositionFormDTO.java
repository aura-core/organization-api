package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.RoleDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record JobPositionFormDTO(
        @NotBlank @Size(max = 80) String name,
        @Size(max = 80) String description,
        Set<RoleDTO> roles) {
}
