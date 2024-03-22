package com.aura.organizationapi.infrastructure.provider.postgres.entity.commons;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ContactEntity {

    @Column(length = 80)
    private String contactEmail;

    @Column(length = 40)
    private String contactPhoneNumber;

    private String contactDescription;

}
