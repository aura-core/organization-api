package com.aura.organizationapi.app.api.dto.commons;

public record AddressDTO(
        String street,
        Integer number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String country,
        String cep) {
}
