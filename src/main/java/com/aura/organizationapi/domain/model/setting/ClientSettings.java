package com.aura.organizationapi.domain.model.setting;

public record ClientSettings(Global global, Organization organization, Ticket ticket) {

    public record Global() {
    }

    public record Organization() {
    }

    public record Ticket() {
    }

}
