package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.ContactDto2;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record DepartmentFormDto(
        @Size(max = 80) String name,
        @Size(max = 80) String description,
        @NotNull UUID responsibleId,
        ContactDto2 contact) {
}
