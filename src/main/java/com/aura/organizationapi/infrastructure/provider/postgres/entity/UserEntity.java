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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80, unique = true, nullable = false)
    private String email;

    @Column(length = 40, unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private ContactEntity contact;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public enum Status {
        ACTIVE,
        INACTIVE,
        PENDING,
        BLOCKED,
        DELETED;
    }

}
