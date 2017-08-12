package com.backend.rybakowka.service;

import com.backend.rybakowka.dto.EquipmentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EquipmentService {

    List<EquipmentDto> getListEquipment();

    EquipmentDto findEquimpentById(Long id);

    EquipmentDto save(EquipmentDto equipmentDto);

    EquipmentDto update(EquipmentDto equipmentDto);

    ResponseEntity delete(Long id);
}
