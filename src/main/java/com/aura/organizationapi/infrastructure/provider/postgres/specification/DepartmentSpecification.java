package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.DepartmentEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DepartmentSpecification implements Specification<DepartmentEntity> {

    private final List<Specification<DepartmentEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(DepartmentSpecifications.nameLike(name));
    }

    public void setResponsibleId(String responsibleId) {
        if (Strings.isBlank(responsibleId)) {
            return;
        }
        filters.add(DepartmentSpecifications.responsibleIdEqual(responsibleId));
    }

    public void setResponsibleName(String responsibleName) {
        if (Strings.isBlank(responsibleName)) {
            return;
        }
        filters.add(DepartmentSpecifications.responsibleNameEqual(responsibleName));
    }

    public void setStatus(DepartmentEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(DepartmentSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Specification<DepartmentEntity> specification = Specification.where(null);
        for (Specification<DepartmentEntity> filter : filters) {
            specification = specification.and(filter);
        }
        return specification.toPredicate(root, query, criteriaBuilder);
    }

}
