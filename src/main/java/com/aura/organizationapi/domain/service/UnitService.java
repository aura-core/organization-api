package com.aura.organizationapi.domain.service;

import com.aura.organizationapi.app.api.dto.UnitDTO;
import com.aura.organizationapi.app.api.dto.UnitFormDTO;
import com.aura.organizationapi.app.api.mapper.UnitMapper;
import com.aura.organizationapi.domain.model.Team;
import com.aura.organizationapi.domain.model.Unit;
import com.aura.organizationapi.domain.model.User;
import com.aura.organizationapi.domain.repository.TeamRepository;
import com.aura.organizationapi.domain.repository.UnitRepository;
import com.aura.organizationapi.domain.util.exception.TeamNotFoundException;
import com.aura.organizationapi.domain.util.exception.UnitNotFoundException;
import com.aura.organizationapi.domain.util.filter.TeamFilter;
import com.aura.organizationapi.domain.util.filter.UnitFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class UnitService {

    private final UnitRepository unitRepository;
    private final UserService userService;

    public Page<Unit> findAll(Pageable pageable, UnitFilter filter) {
        return unitRepository.findAll(pageable, filter);
    }

    public Unit findById(UUID id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new UnitNotFoundException(id));
    }

    public Unit create(UnitFormDTO unitFormDTO) {
        User responsible = userService.findById(unitFormDTO.responsibleId());
        Unit unit = UnitMapper.toUnit(unitFormDTO, responsible);
        return unitRepository.create(unit);
    }

    public Unit update(UUID id, UnitFormDTO unitFormDTO) {
        Unit oldUnit = findById(id);
        User responsible = userService.findById(unitFormDTO.responsibleId());
        Unit unit = UnitMapper.toUnit(oldUnit, unitFormDTO, responsible);
        return unitRepository.update(unit);
    }

    public void deleteById(UUID id) {
        unitRepository.deleteById(id);
    }

}
