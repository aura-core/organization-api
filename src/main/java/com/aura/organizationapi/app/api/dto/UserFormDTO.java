package com.aura.organizationapi.app.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserFormDTO(
        @NotBlank @Size(max = 80) String name,
        @Email @NotBlank @Size(max = 80) String email,
        @NotBlank @Size(max = 40) String login) {
}