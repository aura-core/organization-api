package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.RoleDTO;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.UUID;

public record UserDTO(
        UUID id,
        @Size(max = 80) String name,
        @Size(max = 80) String email,
        @Size(max = 40) String login,
        Set<RoleDTO> roles,
        Status status) {

    public enum Status {
        ACTIVATED,
        INACTIVE,
        PENDING,
        BLOCKED,
        DELETED
    }
}
