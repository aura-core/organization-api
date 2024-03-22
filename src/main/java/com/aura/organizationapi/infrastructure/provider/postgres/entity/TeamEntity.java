package com.aura.organizationapi.infrastructure.provider.postgres.entity;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.commons.ContactEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "teams")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity responsible;

    @Embedded
    private ContactEntity contact;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED;
    }

}
