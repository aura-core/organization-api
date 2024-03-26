package com.aura.organizationapi.domain.service;

import com.aura.organizationapi.app.api.dto.UserFormDTO;
import com.aura.organizationapi.domain.mapper.UserMapper;
import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.repository.UserRepository;
import com.aura.organizationapi.domain.util.exception.UserNotFoundException;
import com.aura.organizationapi.domain.util.filter.UserFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<User> findAll(Pageable pageable, UserFilter filter) {
        return userRepository.findAll(pageable, filter);
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User create(UserFormDTO userFormDTO) {
        User user = userMapper.toUser(userFormDTO);
        return userRepository.create(user);
    }

    public User update(UUID id, UserFormDTO userFormDTO) {
        User user = findById(id);
        userMapper.updateUserFromDTO(user, userFormDTO);
        return userRepository.update(user);
    }

    public User activate(UUID id) {
        User user = findById(id);
        user.setStatus(User.Status.ACTIVATED);
        return userRepository.update(user);
    }

    public User inactivate(UUID id) {
        User user = findById(id);
        user.setStatus(User.Status.INACTIVE);
        return userRepository.update(user);
    }

    public User block(UUID id) {
        User user = findById(id);
        user.setStatus(User.Status.BLOCKED);
        return userRepository.update(user);
    }

    public User logicallyDelete(UUID id) {
        User user = findById(id);
        user.setStatus(User.Status.DELETED);
        return userRepository.update(user);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

}
