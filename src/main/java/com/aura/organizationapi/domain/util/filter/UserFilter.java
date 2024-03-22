package com.aura.organizationapi.domain.util.filter;

import com.aura.organizationapi.domain.model.User;

public record UserFilter(String name, String email, String login, User.Status status) {
}
