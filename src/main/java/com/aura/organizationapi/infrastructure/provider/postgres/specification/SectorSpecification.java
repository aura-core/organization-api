package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.SectorEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SectorSpecification implements Specification<SectorEntity> {

    private final List<Specification<SectorEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(SectorSpecifications.nameLike(name));
    }

    public void setResponsibleId(String responsibleId) {
        if (Strings.isBlank(responsibleId)) {
            return;
        }
        filters.add(SectorSpecifications.responsibleIdEqual(responsibleId));
    }

    public void setResponsibleName(String responsibleName) {
        if (Strings.isBlank(responsibleName)) {
            return;
        }
        filters.add(SectorSpecifications.responsibleNameEqual(responsibleName));
    }

    public void setStatus(SectorEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(SectorSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Specification<SectorEntity> specification = Specification.where(null);
        for (Specification<SectorEntity> filter : filters) {
            specification = specification.and(filter);
        }
        return specification.toPredicate(root, query, criteriaBuilder);
    }

}
