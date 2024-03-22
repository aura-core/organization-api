package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.UserDTO;
import com.aura.organizationapi.app.api.dto.UserFormDTO;
import com.aura.organizationapi.app.api.mapper.UserMapper;
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
import java.util.UUID;

@Slf4j
@SuppressWarnings("unused")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(@PageableDefault Pageable page,
                                                 @RequestParam(required = false) UserFilter filter) {
        Page<User> users = userService.findAll(page, filter);
        Page<UserDTO> usersDTO = users.map(UserMapper::toUserDTO);
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
        User user = userService.findById(id);
        UserDTO dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserFormDTO form) {
        User user = userService.create(form);
        UserDTO dto = UserMapper.toUserDTO(user);
        return ResponseEntity.created(URI.create("/api/v1/users/" + dto.id())).body(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable UUID id, @Valid UserFormDTO form) {
        User user = userService.update(id, form);
        UserDTO dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
