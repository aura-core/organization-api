package com.aura.organizationapi.infrastructure.provider.postgres.entity;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.commons.ContactEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.util.Auditable;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Entity
@Table(name = "users")
public class UserEntity extends Auditable<String> {

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

    public enum Status {
        ACTIVE,
        INACTIVE,
        PENDING,
        BLOCKED,
        DELETED;
    }

}
