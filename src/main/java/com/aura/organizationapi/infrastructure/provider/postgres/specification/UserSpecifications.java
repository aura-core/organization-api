package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class UserSpecifications {

    public static Specification<UserEntity> nameLike(String name) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("name"), '%' + name + '%');
    }

    public static Specification<UserEntity> emailLike(String email) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("email"), '%' + email + '%');
    }

    public static Specification<UserEntity> loginLike(String login) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("login"), '%' + login + '%');
    }

    public static Specification<UserEntity> statusEqual(UserEntity.Status status) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<UserEntity> statusNotEqual(UserEntity.Status status) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}
