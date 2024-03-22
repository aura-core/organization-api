package com.aura.organizationapi.infrastructure.adapter.mapper;

import com.aura.organizationapi.domain.model.Sector;
import com.aura.organizationapi.domain.util.filter.SectorFilter;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.SectorEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.specification.SectorSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SectorEntityMapper {

    public static SectorEntity toSectorEntity(Sector sector) {
        SectorEntity entity = new SectorEntity();
        entity.setId(sector.getId());
        entity.setName(sector.getName());
        entity.setContact(ContactEntityMapper.toContactEntity(sector.getContact()));
        entity.setDescription(sector.getDescription());
        entity.setUpdatedAt(sector.getUpdatedAt());
        entity.setCreatedAt(sector.getCreatedAt());
        entity.setStatus(map(sector.getStatus()));
        entity.setResponsible(UserEntityMapper.toUserEntity(sector.getResponsible()));
        return entity;
    }

    public static Sector toSector(SectorEntity entity) {
        Sector sector = new Sector();
        sector.setId(entity.getId());
        sector.setName(entity.getName());
        sector.setContact(ContactEntityMapper.toContact(entity.getContact()));
        sector.setDescription(entity.getDescription());
        sector.setUpdatedAt(entity.getUpdatedAt());
        sector.setCreatedAt(entity.getCreatedAt());
        sector.setStatus(map(entity.getStatus()));
        sector.setResponsible(UserEntityMapper.toUser(entity.getResponsible()));
        return sector;
    }

    public static SectorSpecification map(SectorFilter sectorFilter) {
        if (sectorFilter == null) {
            return null;
        }
        SectorSpecification specification = new SectorSpecification();
        specification.setName(sectorFilter.name());
        specification.setStatus(map(sectorFilter.status()));
        specification.setResponsibleId(sectorFilter.responsible().id());
        specification.setResponsibleName(sectorFilter.responsible().name());
        return specification;
    }

    private static SectorEntity.Status map(Sector.Status status) {
        if (status == null) {
            return null;
        }
        return SectorEntity.Status.valueOf(status.name());
    }

    private static Sector.Status map(SectorEntity.Status status) {
        if (status == null) {
            return null;
        }
        return Sector.Status.valueOf(status.name());
    }

}
