package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.DepartmentEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.SectorEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class SectorSpecifications {

    public static Specification<SectorEntity> nameLike(String name) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("name"), '%' + name + '%');
    }

    public static Specification<SectorEntity> responsibleIdEqual(String responsibleId) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("responsible.id"), responsibleId);
    }

    public static Specification<SectorEntity> responsibleNameEqual(String responsibleName) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("responsible.name"), responsibleName);
    }

    public static Specification<SectorEntity> statusEqual(SectorEntity.Status status) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<SectorEntity> statusNotEqual(SectorEntity.Status status) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}
