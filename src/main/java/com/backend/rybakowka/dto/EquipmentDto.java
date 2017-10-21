package com.backend.rybakowka.dto;

import com.backend.rybakowka.model.StatusEquipmentEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto {

    private Long id;

    @NotNull
    @Column(unique = true)
    private String serialNumber;

    @NotNull
    private StatusEquipmentEnum statusEquipmentEnum;

    @NotNull
    private boolean isDelated;

    @NotNull
    private Long typeId;
}
