package com.aura.organizationapi.infrastructure.adapter;

import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.repository.UserRepository;
import com.aura.organizationapi.domain.util.filter.UserFilter;
import com.aura.organizationapi.infrastructure.adapter.mapper.UserEntityMapper;
import com.aura.organizationapi.infrastructure.provider.postgres.entity.UserEntity;
import com.aura.organizationapi.infrastructure.provider.postgres.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserEntityRepository userEntityRepository;

    @Override
    public Page<User> findAll(Pageable pageable, UserFilter filter) {
        return userEntityRepository.findAll(UserEntityMapper.map(filter), pageable)
                .map(UserEntityMapper::toUser);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userEntityRepository.findById(id)
                .map(UserEntityMapper::toUser);
    }

    @Override
    public User create(User user) {
        UserEntity entity = UserEntityMapper.toUserEntity(user);
        entity = userEntityRepository.save(entity);
        return UserEntityMapper.toUser(entity);
    }

    @Override
    public User update(User user) {
        UserEntity entity = UserEntityMapper.toUserEntity(user);
        entity = userEntityRepository.save(entity);
        return UserEntityMapper.toUser(entity);
    }

    @Override
    public void deleteById(UUID id) {
        userEntityRepository.deleteById(id);
    }

}
