package com.aura.organizationapi.domain.util.filter;

import com.aura.organizationapi.domain.model.Unit;

public record UnitFilter(String name, User responsible, Unit.Status status) {
    public record User(String id, String name) {
    }
}