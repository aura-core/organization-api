package com.aura.organizationapi.app.api.dto;

import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UserDTO(
        UUID id,
        @Size(max = 80) String name,
        @Size(max = 80) String email,
        @Size(max = 40) String login,
        Status status) {

    public enum Status {
        ACTIVE,
        INACTIVE,
        PENDING,
        BLOCKED,
        DELETED
    }
}
