package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.UserDTO;
import com.aura.organizationapi.app.api.dto.UserFormDTO;
import com.aura.organizationapi.app.api.dto.commons.RoleDTO;
import com.aura.organizationapi.domain.mapper.RoleMapper;
import com.aura.organizationapi.domain.mapper.UserMapper;
import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.service.UserService;
import com.aura.organizationapi.domain.util.filter.UserFilter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@Slf4j
@SuppressWarnings("unused")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(@PageableDefault Pageable page,
                                                 @RequestParam(required = false) UserFilter filter) {
        Page<User> users = userService.findAll(page, filter);
        Page<UserDTO> usersDTO = users.map(userMapper::toUserDTO);
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
        User user = userService.findById(id);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserFormDTO form) {
        User user = userService.create(form);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.created(URI.create("/api/v1/users/" + dto.id())).body(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable UUID id, @Valid UserFormDTO form) {
        User user = userService.update(id, form);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/add-roles/{id}")
    public ResponseEntity<UserDTO> addRoles(@PathVariable UUID id, Set<RoleDTO> rolesDto) {
        User user = userService.addRoles(id, rolesDto);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/remove-roles/{id}")
    public ResponseEntity<UserDTO> removeRoles(@PathVariable UUID id, Set<RoleDTO> rolesDto) {
        User user = userService.removeRoles(id, rolesDto);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/activate/{id}")
    public ResponseEntity<UserDTO> activate(@PathVariable UUID id) {
        User user = userService.activate(id);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<UserDTO> inactivate(@PathVariable UUID id) {
        User user = userService.inactivate(id);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/block/{id}")
    public ResponseEntity<UserDTO> block(@PathVariable UUID id) {
        User user = userService.block(id);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<UserDTO> logicallyDelete(@PathVariable UUID id) {
        User user = userService.logicallyDelete(id);
        UserDTO dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
