package com.backend.rybakowka.model;
import com.backend.rybakowka.dto.EquipmentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    public Equipment(EquipmentDto equipmentDto) {
        this.id = equipmentDto.getId();
        this.serialNumber = equipmentDto.getSerialNumber();
        this.statusEquipmentEnum = equipmentDto.getStatusEquipmentEnum();
        this.isDelated = equipmentDto.isDelated();
        this.typeId = equipmentDto.getTypeId();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String serialNumber;

    @NotNull
    private StatusEquipmentEnum statusEquipmentEnum;

    @NotNull
    private boolean isDelated;

    @NotNull
    private Long typeId;

    public EquipmentDto toDto() {
        return EquipmentDto.builder()
                .id((this.id))
                .serialNumber(this.serialNumber)
                .statusEquipmentEnum(this.statusEquipmentEnum)
                .isDelated(this.isDelated)
                .typeId(this.typeId)
                .build();
    }

}
