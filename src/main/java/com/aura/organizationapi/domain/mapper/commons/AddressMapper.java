package com.aura.organizationapi.domain.mapper.commons;

import com.aura.organizationapi.app.api.dto.commons.AddressDTO;
import com.aura.organizationapi.domain.model.commons.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressDTO toAddressDTO(Address address);

    Address toAddress(AddressDTO addressDTO);

}
