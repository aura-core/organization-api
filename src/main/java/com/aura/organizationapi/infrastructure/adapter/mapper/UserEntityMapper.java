package com.aura.organizationapi.infrastructure.adapter.mapper;

import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.util.filter.UserFilter;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.UserEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.specification.UserSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntityMapper {

    public static UserEntity toUserEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setLogin(user.getLogin());
        entity.setStatus(map(user.getStatus()));
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }

    public static User toUser(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setLogin(entity.getLogin());
        user.setStatus(map(entity.getStatus()));
        user.setCreatedAt(entity.getCreatedAt());
        user.setUpdatedAt(entity.getUpdatedAt());
        return user;
    }

    public static UserSpecification map(UserFilter userFilter) {
        if (userFilter == null) {
            return null;
        }
        UserSpecification specification = new UserSpecification();
        specification.setName(userFilter.name());
        specification.setEmail(userFilter.email());
        specification.setLogin(userFilter.login());
        specification.setStatus(map(userFilter.status()));
        return specification;
    }

    private static UserEntity.Status map(User.Status status) {
        if (status == null) {
            return null;
        }
        return UserEntity.Status.valueOf(status.name());
    }

    private static User.Status map(UserEntity.Status status) {
        if (status == null) {
            return null;
        }
        return User.Status.valueOf(status.name());
    }

}
