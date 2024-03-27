package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.RoleDTO;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record JobPositionDto(
        UUID id,
        @Size(max = 80) String name,
        @Size(max = 80) String description,
        Set<RoleDTO> roles,
        Status status,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy) {

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED
    }

}
