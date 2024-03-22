package com.aura.organizationapi.infrastructure.adapter.mapper;

import com.aura.organizationapi.domain.model.commons.Contact;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.commons.ContactEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContactEntityMapper {

    public static ContactEntity toContactEntity(Contact contact) {
        ContactEntity entity = new ContactEntity();
        entity.setContactEmail(contact.getEmail());
        entity.setContactPhoneNumber(contact.getPhoneNumber());
        entity.setContactDescription(contact.getDescription());
        return entity;
    }

    public static Contact toContact(ContactEntity entity) {
        Contact contact = new Contact();
        contact.setEmail(entity.getContactEmail());
        contact.setPhoneNumber(entity.getContactPhoneNumber());
        contact.setDescription(entity.getContactDescription());
        return contact;
    }

}
