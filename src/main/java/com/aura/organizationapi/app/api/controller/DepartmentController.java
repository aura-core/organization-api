package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.DepartmentDto;
import com.aura.organizationapi.app.api.dto.DepartmentFormDto;
import com.aura.organizationapi.domain.mapper.DepartmentMapper;
import com.aura.organizationapi.domain.model.Department;
import com.aura.organizationapi.domain.service.DepartmentService;
import com.aura.organizationapi.domain.util.filter.DepartmentFilter;
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
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @GetMapping
    public ResponseEntity<Page<DepartmentDto>> findAll(@PageableDefault Pageable page,
                                                       @RequestParam(required = false) DepartmentFilter filter) {
        Page<Department> departments = departmentService.findAll(page, filter);
        Page<DepartmentDto> departmentsDTO = departments.map(departmentMapper::toDepartmentDTO);
        return ResponseEntity.ok(departmentsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> findById(@PathVariable UUID id) {
        Department department = departmentService.findById(id);
        DepartmentDto dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> create(@RequestBody @Valid DepartmentFormDto form) {
        Department department = departmentService.create(form);
        DepartmentDto dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.created(URI.create("/api/v1/departments/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> update(@PathVariable UUID id, @RequestBody @Valid DepartmentFormDto form) {
        Department department = departmentService.update(id, form);
        DepartmentDto dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<DepartmentDto> inactivate(@PathVariable UUID id) {
        Department department = departmentService.inactivate(id);
        DepartmentDto dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<DepartmentDto> logicallyDelete(@PathVariable UUID id) {
        Department department = departmentService.logicallyDelete(id);
        DepartmentDto dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
