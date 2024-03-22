package com.aura.organizationapi.app.api.dto;

import com.aura.organizationapi.app.api.dto.commons.AddressDTO;
import com.aura.organizationapi.app.api.dto.commons.ContactDTO;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UnitDTO(
        UUID id,
        @Size(max = 80) String name,
        @Size(max = 80) String description,
        UserDTO responsible,
        AddressDTO address,
        ContactDTO contact,
        String status) {
}
