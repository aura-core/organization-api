package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.UnitEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UnitSpecification implements Specification<UnitEntity> {

    private final List<Specification<UnitEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(UnitSpecifications.nameLike(name));
    }

    public void setResponsibleId(String responsibleId) {
        if (Strings.isBlank(responsibleId)) {
            return;
        }
        filters.add(UnitSpecifications.responsibleIdEqual(responsibleId));
    }

    public void setResponsibleName(String responsibleName) {
        if (Strings.isBlank(responsibleName)) {
            return;
        }
        filters.add(UnitSpecifications.responsibleNameEqual(responsibleName));
    }

    public void setStatus(UnitEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(UnitSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Specification<UnitEntity> specification = Specification.where(null);
        for (Specification<UnitEntity> filter : filters) {
            specification = specification.and(filter);
        }
        return specification.toPredicate(root, query, criteriaBuilder);
    }

}
