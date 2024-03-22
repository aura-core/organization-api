package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.UserDTO;
import com.aura.organizationapi.app.api.dto.UserFormDTO;
import com.aura.organizationapi.domain.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserFormDTO userFormDTO) {
        User user = new User();
        user.setName(userFormDTO.name());
        user.setEmail(userFormDTO.email());
        user.setLogin(userFormDTO.login());
        return user;
    }

    public static User toUser(User oldUser, UserFormDTO userFormDTO) {
        oldUser.setName(userFormDTO.name());
        oldUser.setEmail(userFormDTO.email());
        oldUser.setLogin(userFormDTO.login());
        return oldUser;
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getLogin(),
            map(user.getStatus())
        );
    }

    private static UserDTO.Status map(User.Status status) {
        return UserDTO.Status.valueOf(status.name());
    }

}
