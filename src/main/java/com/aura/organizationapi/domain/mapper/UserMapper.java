package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.UserDTO;
import com.aura.organizationapi.app.api.dto.UserFormDTO;
import com.aura.organizationapi.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toUser(UserFormDTO userFormDTO);

    void updateUserFromDTO(@MappingTarget User user, UserFormDTO userFormDTO);

    UserDTO toUserDTO(User user);

}
