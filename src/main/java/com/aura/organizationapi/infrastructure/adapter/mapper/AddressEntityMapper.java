package com.aura.organizationapi.infrastructure.adapter.mapper;

import com.aura.organizationapi.domain.model.commons.Address;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.commons.AddressEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddressEntityMapper {

    public static AddressEntity toAddressEntity(Address address) {
        AddressEntity entity = new AddressEntity();
        entity.setAddressCep(address.getCep());
        entity.setAddressCity(address.getCity());
        entity.setAddressComplement(address.getComplement());
        entity.setAddressNumber(address.getNumber());
        entity.setAddressCountry(address.getCountry());
        entity.setAddressNeighborhood(address.getNeighborhood());
        entity.setAddressState(address.getState());
        entity.setAddressStreet(address.getStreet());
        return entity;
    }

    public static Address toAddress(AddressEntity entity) {
        Address address = new Address();
        address.setCep(entity.getAddressCep());
        address.setCity(entity.getAddressCity());
        address.setComplement(entity.getAddressComplement());
        address.setNumber(entity.getAddressNumber());
        address.setCountry(entity.getAddressCountry());
        address.setNeighborhood(entity.getAddressNeighborhood());
        address.setState(entity.getAddressState());
        address.setStreet(entity.getAddressStreet());
        return address;
    }

}
