package com.aura.organizationapi.infrastructure.provider.postgres.entity.commons;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AddressEntity {

    @Column(length = 80)
    private String AddressStreet;

    private Integer addressNumber;

    @Column(length = 60)
    private String addressComplement;

    @Column(length = 60)
    private String addressNeighborhood;

    @Column(length = 60)
    private String addressCity;

    @Column(length = 60)
    private String addressState;

    @Column(length = 2)
    private String addressCountryAcronym;

    @Column(length = 60)
    private String addressCountry;

    @Column(length = 10)
    private String addressCep;

}
