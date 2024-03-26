package com.aura.organizationapi.app.api.controller;

import com.aura.organizationapi.app.api.dto.DepartmentDTO;
import com.aura.organizationapi.app.api.dto.DepartmentFormDTO;
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
    public ResponseEntity<Page<DepartmentDTO>> findAll(@PageableDefault Pageable page,
                                                       @RequestParam(required = false) DepartmentFilter filter) {
        Page<Department> departments = departmentService.findAll(page, filter);
        Page<DepartmentDTO> departmentsDTO = departments.map(departmentMapper::toDepartmentDTO);
        return ResponseEntity.ok(departmentsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable UUID id) {
        Department department = departmentService.findById(id);
        DepartmentDTO dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> create(@RequestBody @Valid DepartmentFormDTO form) {
        Department department = departmentService.create(form);
        DepartmentDTO dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.created(URI.create("/api/v1/departments/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> update(@PathVariable UUID id, @RequestBody @Valid DepartmentFormDTO form) {
        Department department = departmentService.update(id, form);
        DepartmentDTO dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<DepartmentDTO> inactivate(@PathVariable UUID id) {
        Department department = departmentService.inactivate(id);
        DepartmentDTO dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<DepartmentDTO> logicallyDelete(@PathVariable UUID id) {
        Department department = departmentService.logicallyDelete(id);
        DepartmentDTO dto = departmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
