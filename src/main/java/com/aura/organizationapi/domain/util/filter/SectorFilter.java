package com.aura.organizationapi.domain.util.filter;

import com.aura.organizationapi.domain.model.Sector;

public record SectorFilter(String name, User responsible, Sector.Status status) {
    public record User(String id, String name) {
    }
}