package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.UserDto;
import com.aura.organizationapi.app.api.dto.UserFormDto;
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
    public ResponseEntity<Page<UserDto>> findAll(@PageableDefault Pageable page,
                                                 @RequestParam(required = false) UserFilter filter) {
        Page<User> users = userService.findAll(page, filter);
        Page<UserDto> usersDTO = users.map(userMapper::toUserDTO);
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable UUID id) {
        User user = userService.findById(id);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserFormDto form) {
        User user = userService.create(form);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.created(URI.create("/api/v1/users/" + dto.id())).body(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable UUID id, @Valid UserFormDto form) {
        User user = userService.update(id, form);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/add-roles/{id}")
    public ResponseEntity<UserDto> addRoles(@PathVariable UUID id, Set<RoleDTO> rolesDto) {
        User user = userService.addRoles(id, rolesDto);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/remove-roles/{id}")
    public ResponseEntity<UserDto> removeRoles(@PathVariable UUID id, Set<RoleDTO> rolesDto) {
        User user = userService.removeRoles(id, rolesDto);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/activate/{id}")
    public ResponseEntity<UserDto> activate(@PathVariable UUID id) {
        User user = userService.activate(id);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<UserDto> inactivate(@PathVariable UUID id) {
        User user = userService.inactivate(id);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/block/{id}")
    public ResponseEntity<UserDto> block(@PathVariable UUID id) {
        User user = userService.block(id);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<UserDto> logicallyDelete(@PathVariable UUID id) {
        User user = userService.logicallyDelete(id);
        UserDto dto = userMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
