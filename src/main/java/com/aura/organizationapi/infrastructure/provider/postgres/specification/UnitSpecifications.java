package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.UnitEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class UnitSpecifications {

    public static Specification<UnitEntity> nameLike(String name) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("name"), '%' + name + '%');
    }

    public static Specification<UnitEntity> responsibleIdEqual(String responsibleId) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("responsible.id"), responsibleId);
    }

    public static Specification<UnitEntity> responsibleNameEqual(String responsibleName) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("responsible.name"), responsibleName);
    }

    public static Specification<UnitEntity> statusEqual(UnitEntity.Status status) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<UnitEntity> statusNotEqual(UnitEntity.Status status) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}
