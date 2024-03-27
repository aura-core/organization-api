package com.aura.organizationapi.domain.service;

import com.aura.organizationapi.app.api.dto.UserFormDto;
import com.aura.organizationapi.app.api.dto.commons.RoleDto;
import com.aura.organizationapi.domain.mapper.RoleMapper;
import com.aura.organizationapi.domain.mapper.UserMapper;
import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.model.commons.Role;
import com.aura.organizationapi.domain.repository.UserRepository;
import com.aura.organizationapi.domain.util.exception.UserNotFoundException;
import com.aura.organizationapi.domain.util.filter.UserFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    public Page<User> findAll(Pageable pageable, UserFilter filter) {
        return userRepository.findAll(pageable, filter);
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User create(UserFormDto userFormDTO) {
        User user = userMapper.toUser(userFormDTO);
        return userRepository.create(user);
    }

    public User update(UUID id, UserFormDto userFormDTO) {
        User user = findById(id);
        userMapper.updateUserFromDTO(user, userFormDTO);
        return userRepository.update(user);
    }

    public User addRoles(UUID id, Set<RoleDto> rolesDTO) {
        User user = findById(id);
        Set<Role> roles = roleMapper.toRole(rolesDTO);
        user.getRoles().addAll(roles);
        return userRepository.update(user);
    }

    public User removeRoles(UUID id, Set<RoleDto> rolesDTO) {
        User user = findById(id);
        Set<Role> roles = roleMapper.toRole(rolesDTO);
        user.getRoles().removeAll(roles);
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
