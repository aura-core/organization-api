package com.aura.organizationapi.domain.model.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private String email;
    private String phoneNumber;
    private String description;

}
