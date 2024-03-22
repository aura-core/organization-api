package com.aura.organizationapi.infrastructure.adapter.mapper;

import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.util.filter.UnitFilter;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.UnitEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.specification.UnitSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitEntityMapper {

    public static UnitEntity toUnitEntity(Unit unit) {
        UnitEntity entity = new UnitEntity();
        entity.setId(unit.getId());
        entity.setName(unit.getName());
        entity.setAddress(AddressEntityMapper.toAddressEntity(unit.getAddress()));
        entity.setContact(ContactEntityMapper.toContactEntity(unit.getContact()));
        entity.setDescription(unit.getDescription());
        entity.setUpdatedAt(unit.getUpdatedAt());
        entity.setCreatedAt(unit.getCreatedAt());
        entity.setStatus(map(unit.getStatus()));
        entity.setResponsible(UserEntityMapper.toUserEntity(unit.getResponsible()));
        return entity;
    }

    public static Unit toUnit(UnitEntity entity) {
        Unit unit = new Unit();
        unit.setId(entity.getId());
        unit.setName(entity.getName());
        unit.setAddress(AddressEntityMapper.toAddress(entity.getAddress()));
        unit.setContact(ContactEntityMapper.toContact(entity.getContact()));
        unit.setDescription(entity.getDescription());
        unit.setUpdatedAt(entity.getUpdatedAt());
        unit.setCreatedAt(entity.getCreatedAt());
        unit.setStatus(map(entity.getStatus()));
        unit.setResponsible(UserEntityMapper.toUser(entity.getResponsible()));
        return unit;
    }

    public static UnitSpecification map(UnitFilter unitFilter) {
        if (unitFilter == null) {
            return null;
        }
        UnitSpecification specification = new UnitSpecification();
        specification.setName(unitFilter.name());
        specification.setResponsibleId(unitFilter.responsible().id());
        specification.setResponsibleName(unitFilter.responsible().name());
        specification.setStatus(map(unitFilter.status()));
        return specification;
    }

    private static UnitEntity.Status map(Unit.Status status) {
        if (status == null) {
            return null;
        }
        return UnitEntity.Status.valueOf(status.name());
    }

    private static Unit.Status map(UnitEntity.Status status) {
        if (status == null) {
            return null;
        }
        return Unit.Status.valueOf(status.name());
    }

}
