package com.aura.organizationapi.domain.repository;

import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.util.filter.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Page<User> findAll(Pageable pageable, UserFilter filter);
    Optional<User> findById(UUID id);
    User create(User user);
    User update(User user);
    void deleteById(UUID id);

}
