package com.backend.rybakowka.service.impl;

import com.backend.rybakowka.dto.EquipmentDto;
import com.backend.rybakowka.exception.EquipmentException;
import com.backend.rybakowka.model.Equipment;
import com.backend.rybakowka.repository.EquipmentRepository;
import com.backend.rybakowka.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<EquipmentDto> getListEquipment() {
        return equipmentRepository.findAll().stream()
                .map(Equipment::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EquipmentDto findEquimpentById(Long id) {
        return Optional.ofNullable(equipmentRepository.findOne(id))
                .orElseThrow(
                        () -> new EquipmentException("Equipment doesn't exixts!"))
                .toDto();
    }

    @Override
    public EquipmentDto save(EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment(equipmentDto);
        return equipmentRepository.saveAndFlush(equipment).toDto();
    }

    @Override
    public EquipmentDto update(EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment(equipmentDto);
        return equipmentRepository.saveAndFlush(equipment).toDto(); //// ??????????? zapisuje jako nowe teraz
    }

    @Override
    public ResponseEntity delete(Long id) {
        equipmentRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}
