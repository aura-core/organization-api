package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.SectorDto;
import com.aura.organizationapi.app.api.dto.SectorFormDto;
import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SectorMapper {

    Sector toSector(SectorFormDto sectorFormDTO);

    default Sector toSector(SectorFormDto sectorFormDTO, User responsible) {
        if (sectorFormDTO == null) {
            return null;
        }
        Sector sector = toSector(sectorFormDTO);
        sector.setResponsible(responsible);
        return sector;
    }

    void updateSectorFromDTO(@MappingTarget Sector sector, SectorFormDto sectorFormDTO);

    default void updateSectorFromDTO(@MappingTarget Sector sector, SectorFormDto sectorFormDTO, User responsible) {
        if (sector == null) {
            return;
        }
        updateSectorFromDTO(sector, sectorFormDTO);
        sector.setResponsible(responsible);
    }

    SectorDto toSectorDTO(Sector sector);

}
