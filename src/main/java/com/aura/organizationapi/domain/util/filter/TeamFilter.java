package com.aura.organizationapi.domain.util.filter;

import com.aura.organizationapi.domain.model.Team;

public record TeamFilter(String name, User responsible, Team.Status status) {
    public record User(String id, String name) {
    }
}