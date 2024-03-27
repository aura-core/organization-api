package com.aura.organizationapi.domain.mapper;

import com.aura.organizationapi.app.api.dto.UserDto;
import com.aura.organizationapi.app.api.dto.UserFormDto;
import com.aura.organizationapi.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toUser(UserFormDto userFormDTO);

    void updateUserFromDTO(@MappingTarget User user, UserFormDto userFormDTO);

    UserDto toUserDTO(User user);

}
