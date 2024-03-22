package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.TeamEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class TeamSpecifications {

    public static Specification<TeamEntity> nameLike(String name) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("name"), '%' + name + '%');
    }

    public static Specification<TeamEntity> responsibleIdEqual(String responsibleId) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("responsible.id"), responsibleId);
    }

    public static Specification<TeamEntity> responsibleNameEqual(String responsibleName) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("responsible.name"), responsibleName);
    }

    public static Specification<TeamEntity> statusEqual(TeamEntity.Status status) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<TeamEntity> statusNotEqual(TeamEntity.Status status) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}
