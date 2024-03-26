package com.aura.organizationapi.domain.mapper.commons;

import com.aura.organizationapi.app.api.dto.commons.ContactDTO;
import com.aura.organizationapi.domain.model.commons.Contact;
import lombok.experimental.UtilityClass;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {

    ContactDTO toContactDTO(Contact contact);

    Contact toContact(ContactDTO contactDTO);

}
