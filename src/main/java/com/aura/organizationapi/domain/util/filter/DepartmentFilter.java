package com.aura.organizationapi.domain.util.filter;

import com.aura.organizationapi.domain.model.Department;

public record DepartmentFilter(String name, User responsible, Department.Status status) {
    public record User(String id, String name) {
    }
}