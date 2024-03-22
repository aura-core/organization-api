package com.aura.organizationapi.infrastructure.provider.postgres.specification;

import com.aura.organizationapi.infrastructure.provider.postgres.entity.TeamEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TeamSpecification implements Specification<TeamEntity> {

    private final List<Specification<TeamEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(TeamSpecifications.nameLike(name));
    }

    public void setResponsibleId(String responsibleId) {
        if (Strings.isBlank(responsibleId)) {
            return;
        }
        filters.add(TeamSpecifications.responsibleIdEqual(responsibleId));
    }

    public void setResponsibleName(String responsibleName) {
        if (Strings.isBlank(responsibleName)) {
            return;
        }
        filters.add(TeamSpecifications.responsibleNameEqual(responsibleName));
    }

    public void setStatus(TeamEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(TeamSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Specification<TeamEntity> specification = Specification.where(null);
        for (Specification<TeamEntity> filter : filters) {
            specification = specification.and(filter);
        }
        return specification.toPredicate(root, query, criteriaBuilder);
    }

}
