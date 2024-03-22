package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.commons.ContactDTO;
import com.aura.organizationapi.domain.model.commons.Contact;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContactMapper {

    public static ContactDTO toContactDTO(Contact contact) {
        return new ContactDTO(contact.getEmail(), contact.getPhoneNumber(), contact.getDescription());
    }

    public static Contact toContact(ContactDTO contactDTO) {
        return new Contact(contactDTO.email(), contactDTO.phoneNumber(), contactDTO.description());
    }

}
