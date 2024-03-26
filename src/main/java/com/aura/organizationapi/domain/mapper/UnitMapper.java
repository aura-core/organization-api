package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.UnitDTO;
import com.aura.organizationapi.app.api.dto.UnitFormDTO;
import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UnitMapper {

    Unit toUnit(UnitFormDTO unitFormDTO);

    default Unit toUnit(UnitFormDTO unitFormDTO, User responsible) {
        if (unitFormDTO == null) {
            return null;
        }
        Unit unit = toUnit(unitFormDTO);
        unit.setResponsible(responsible);
        return unit;
    }

    void updateUnitFromDTO(@MappingTarget Unit unit, UnitFormDTO unitFormDTO);

    default void updateUnitFromDTO(@MappingTarget Unit unit, UnitFormDTO unitFormDTO, User responsible) {
        if (unit == null) {
            return;
        }
        updateUnitFromDTO(unit, unitFormDTO);
        unit.setResponsible(responsible);
    }

    UnitDTO toUnitDTO(Unit unit);

}
