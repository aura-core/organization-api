package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.AddressDto2;
import com.aura.organizationapi.app.api.dto.commons.ContactDto2;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record UnitDto(
        UUID id,
        @Size(max = 80) String name,
        @Size(max = 80) String description,
        UserDto responsible,
        AddressDto2 address,
        ContactDto2 contact,
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
