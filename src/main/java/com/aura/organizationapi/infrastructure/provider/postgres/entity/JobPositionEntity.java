package com.aura.organizationapi.infrastructure.provider.postgres.entity;

import com.aura.organizationapi.infrastructure.provider.postgres.util.Auditable;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Entity
@Table(name = "possitions")
public class JobPositionEntity extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80)
    private String description;

    @Column(length = 80)
    @ElementCollection
    private Set<String> roles;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED;
    }

}
