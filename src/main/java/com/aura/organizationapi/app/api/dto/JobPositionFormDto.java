package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.RoleDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record JobPositionFormDto(
        @NotBlank @Size(max = 80) String name,
        @Size(max = 80) String description,
        Set<RoleDto> roles) {
}
