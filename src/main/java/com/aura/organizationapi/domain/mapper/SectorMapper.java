package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.SectorDTO;
import com.aura.organizationapi.app.api.dto.SectorFormDTO;
import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SectorMapper {

    Sector toSector(SectorFormDTO sectorFormDTO);

    default Sector toSector(SectorFormDTO sectorFormDTO, User responsible) {
        if (sectorFormDTO == null) {
            return null;
        }
        Sector sector = toSector(sectorFormDTO);
        sector.setResponsible(responsible);
        return sector;
    }

    void updateSectorFromDTO(@MappingTarget Sector sector, SectorFormDTO sectorFormDTO);

    default void updateSectorFromDTO(@MappingTarget Sector sector, SectorFormDTO sectorFormDTO, User responsible) {
        if (sector == null) {
            return;
        }
        updateSectorFromDTO(sector, sectorFormDTO);
        sector.setResponsible(responsible);
    }

    SectorDTO toSectorDTO(Sector sector);

}
