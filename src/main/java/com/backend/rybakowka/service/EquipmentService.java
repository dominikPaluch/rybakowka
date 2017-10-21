package com.backend.rybakowka.service;

import com.backend.rybakowka.dto.EquipmentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EquipmentService {

    List<EquipmentDto> getListEquipment();

    EquipmentDto findEquimpentById(Long id);

    EquipmentDto add(EquipmentDto equipmentDto);

    EquipmentDto update(EquipmentDto equipmentDto);

    EquipmentDto delete(EquipmentDto equipmentDto);
}
