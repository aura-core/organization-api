package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.DepartmentEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class DepartmentSpecifications {

    public static Specification<DepartmentEntity> nameLike(String name) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("name"), '%' + name + '%');
    }

    public static Specification<DepartmentEntity> responsibleIdEqual(String responsibleId) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("responsible.id"), responsibleId);
    }

    public static Specification<DepartmentEntity> responsibleNameEqual(String responsibleName) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("responsible.name"), responsibleName);
    }

    public static Specification<DepartmentEntity> statusEqual(DepartmentEntity.Status status) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<DepartmentEntity> statusNotEqual(DepartmentEntity.Status status) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}
