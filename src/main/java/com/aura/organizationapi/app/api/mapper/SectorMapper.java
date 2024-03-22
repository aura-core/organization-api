package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.SectorDTO;
import com.aura.organizationapi.app.api.dto.SectorFormDTO;
import com.aura.organizationapi.app.api.mapper.commons.ContactMapper;
import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SectorMapper {

    public static Sector toSector(SectorFormDTO sectorFormDTO, User responsible) {
        Sector sector = new Sector();
        sector.setResponsible(responsible);
        sector.setName(sectorFormDTO.name());
        sector.setDescription(sectorFormDTO.description());
        sector.setContact(ContactMapper.toContact(sectorFormDTO.contact()));
        return sector;
    }

    public static Sector toSector(Sector oldSector, SectorFormDTO sectorFormDTO, User responsible) {
        oldSector.setResponsible(responsible);
        oldSector.setName(sectorFormDTO.name());
        oldSector.setDescription(sectorFormDTO.description());
        oldSector.setContact(ContactMapper.toContact(sectorFormDTO.contact()));
        return oldSector;
    }

    public static SectorDTO toSectorDTO(Sector sector) {
        return new SectorDTO(
            sector.getId(),
            sector.getName(),
            sector.getDescription(),
            UserMapper.toUserDTO(sector.getResponsible()),
            ContactMapper.toContactDTO(sector.getContact()),
            map(sector.getStatus())
        );
    }

    public static SectorDTO.Status map(Sector.Status status) {
        return SectorDTO.Status.valueOf(status.name());
    }

}
