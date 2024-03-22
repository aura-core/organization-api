package com.aura.organizationapi.domain.util.filter;

import com.aura.organizationapi.domain.model.JobPosition;

public record JobPositionFilter(String name, JobPosition.Status status) {
}