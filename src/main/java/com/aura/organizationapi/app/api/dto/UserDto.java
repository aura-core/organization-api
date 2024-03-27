package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.RoleDto;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record UserDto(
        UUID id,
        @Size(max = 80) String name,
        @Size(max = 80) String email,
        @Size(max = 40) String login,
        Set<RoleDto> roles,
        Status status,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy) {

    public enum Status {
        ACTIVATED,
        INACTIVE,
        PENDING,
        BLOCKED,
        DELETED
    }
}
