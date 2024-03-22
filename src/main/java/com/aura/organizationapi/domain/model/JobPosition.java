package com.aura.organizationapi.domain.model;

import com.aura.organizationapi.domain.model.commons.Role;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class JobPosition {

    private UUID id;
    private String name;
    private String description;
    private Set<Role> roles;
    private Status status = Status.ACTIVE;
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
