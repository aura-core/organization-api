package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.ContactDTO;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record TeamDto(
        UUID id,
        @Size(max = 80) String name,
        @Size(max = 80) String description,
        UserDto responsible,
        ContactDTO contact,
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
