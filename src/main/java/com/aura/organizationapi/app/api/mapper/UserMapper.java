package com.aura.organizationapi.app.api.mapper;

import com.aura.organizationapi.app.api.dto.UserDTO;
import com.aura.organizationapi.app.api.dto.UserFormDTO;
import com.aura.organizationapi.domain.model.User;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class UserMapper {

    public static User toUser(UserFormDTO userFormDTO) {
        User user = new User();
        user.setName(userFormDTO.name());
        user.setEmail(userFormDTO.email());
        user.setLogin(userFormDTO.login());
        user.setStatus(User.Status.PENDING);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }

    public static User toUser(User oldUser, UserFormDTO userFormDTO) {
        //User user = new User();
        //user.setId(userDTO.id());
        //user.setName(userDTO.name());
        //user.setEmail(userDTO.email());
        //user.setLogin(userDTO.login());
        //user.setStatus(map(userDTO.status()));
        //return user;
        return null;
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

    private static User.Status map(UserDTO.Status statusDto) {
        return User.Status.valueOf(statusDto.name());
    }

}
