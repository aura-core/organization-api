package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.JobPositionEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class JobPositionSpecification implements Specification<JobPositionEntity> {

    private final List<Specification<JobPositionEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(JobPositionSpecifications.nameLike(name));
    }

    public void setStatus(JobPositionEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(JobPositionSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<JobPositionEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Specification<JobPositionEntity> specification = Specification.where(null);
        for (Specification<JobPositionEntity> filter : filters) {
            specification = specification.and(filter);
        }
        return specification.toPredicate(root, query, criteriaBuilder);
    }

}
