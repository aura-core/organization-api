package com.aura.organizationapi.domain.model;

import com.aura.organizationapi.domain.model.commons.Contact;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Sector {

    private UUID id;
    private String name;
    private String description;
    private User responsible;
    private Contact contact;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        DELETED("Deleted");

        private final String description;
    }

}
