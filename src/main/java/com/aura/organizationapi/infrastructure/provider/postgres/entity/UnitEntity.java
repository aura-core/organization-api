package com.aura.organizationapi.infrastructure.provider.postgres.entity;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.commons.AddressEntity;
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
@Table(name = "units")
public class UnitEntity extends Auditable<String> {

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
    private AddressEntity address;

    @Embedded
    private ContactEntity contact;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED;
    }

}
