package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<UserEntity> {

    private final List<Specification<UserEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(UserSpecifications.nameLike(name));
    }

    public void setEmail(String email) {
        if (Strings.isBlank(email)) {
            return;
        }
        filters.add(UserSpecifications.emailLike(email));
    }

    public void setLogin(String login) {
        if (Strings.isBlank(login)) {
            return;
        }
        filters.add(UserSpecifications.loginLike(login));
    }

    public void setStatus(UserEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(UserSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Specification<UserEntity> specification = Specification.where(null);
        for (Specification<UserEntity> filter : filters) {
            specification = specification.and(filter);
        }
        return specification.toPredicate(root, query, criteriaBuilder);
    }

}
