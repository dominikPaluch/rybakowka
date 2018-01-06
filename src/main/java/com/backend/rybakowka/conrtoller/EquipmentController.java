package com.backend.rybakowka.conrtoller;

import com.backend.rybakowka.dto.EquipmentDto;
import com.backend.rybakowka.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipments")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class EquipmentController {

    private EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<EquipmentDto> getListAccount() {
        return equipmentService.getListEquipment();
    }

    @GetMapping(value = "/{id}")
    public EquipmentDto findAccountById(@PathVariable Long id) {
        return equipmentService.findEquimpentById(id);
    }

    @PostMapping()
    public @ResponseBody
    EquipmentDto save(@RequestBody @Valid EquipmentDto equipmentDto) {
        equipmentService.add(equipmentDto);

        return equipmentDto;
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody
    EquipmentDto update(@PathVariable("id") Long id, @RequestBody EquipmentDto equipmentDto) {
//        equipmentDto.setId(id);
        equipmentService.update(equipmentDto);
        return equipmentDto;
    }

    @DeleteMapping(value = "/{id}")
    public EquipmentDto delete(@PathVariable("id") Long id, @RequestBody EquipmentDto equipmentDto) {
        return equipmentService.delete(equipmentDto);
    }
}
