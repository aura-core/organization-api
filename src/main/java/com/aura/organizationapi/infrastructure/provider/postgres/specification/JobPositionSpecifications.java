package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.JobPositionEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class JobPositionSpecifications {

    public static Specification<JobPositionEntity> nameLike(String name) {
        return (Root<JobPositionEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("name"), '%' + name + '%');
    }

    public static Specification<JobPositionEntity> statusEqual(JobPositionEntity.Status status) {
        return (Root<JobPositionEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<JobPositionEntity> statusNotEqual(JobPositionEntity.Status status) {
        return (Root<JobPositionEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}
