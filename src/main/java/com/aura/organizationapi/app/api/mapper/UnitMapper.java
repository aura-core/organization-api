package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.UnitDTO;
import com.aura.organizationapi.app.api.dto.UnitFormDTO;
import com.aura.organizationapi.app.api.mapper.commons.AddressMapper;
import com.aura.organizationapi.app.api.mapper.commons.ContactMapper;
import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitMapper {

    public static Unit toUnit(UnitFormDTO unitFormDTO, User responsible) {
        Unit unit = new Unit();
        unit.setName(unitFormDTO.name());
        unit.setDescription(unitFormDTO.description());
        unit.setResponsible(responsible);
        unit.setAddress(AddressMapper.toAddress(unitFormDTO.address()));
        unit.setContact(ContactMapper.toContact(unitFormDTO.contact()));
        return unit;
    }

    public static Unit toUnit(Unit oldUnit, UnitFormDTO unitFormDTO, User responsible) {
        oldUnit.setName(unitFormDTO.name());
        oldUnit.setDescription(unitFormDTO.description());
        oldUnit.setResponsible(responsible);
        oldUnit.setAddress(AddressMapper.toAddress(unitFormDTO.address()));
        oldUnit.setContact(ContactMapper.toContact(unitFormDTO.contact()));
        return oldUnit;
    }

    public static UnitDTO toUnitDTO(Unit unit) {
        return new UnitDTO(
            unit.getId(),
            unit.getName(),
            unit.getDescription(),
            UserMapper.toUserDTO(unit.getResponsible()),
            AddressMapper.toAddressDTO(unit.getAddress()),
            ContactMapper.toContactDTO(unit.getContact()),
            map(unit.getStatus())
        );
    }

    public static UnitDTO.Status map(Unit.Status status) {
        return UnitDTO.Status.valueOf(status.name());
    }

}
