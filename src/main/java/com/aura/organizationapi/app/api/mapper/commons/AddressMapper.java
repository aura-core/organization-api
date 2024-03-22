package com.aura.organizationapi.app.api.mapper.commons;

import com.aura.organizationapi.app.api.dto.commons.AddressDTO;
import com.aura.organizationapi.domain.model.commons.Address;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddressMapper {

    public static AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(
            address.getStreet(),
            address.getNumber(),
            address.getComplement(),
            address.getNeighborhood(),
            address.getCity(),
            address.getState(),
            address.getCountry(),
            address.getCep()
        );
    }

    public static Address toAddress(AddressDTO addressDTO) {
        return new Address(
            addressDTO.street(),
            addressDTO.number(),
            addressDTO.complement(),
            addressDTO.neighborhood(),
            addressDTO.city(),
            addressDTO.state(),
            addressDTO.country(),
            addressDTO.cep()
        );
    }

}
