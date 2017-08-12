package com.backend.rybakowka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto {

    private String serialNumber;

    //    @NotNull
    private boolean inStock;

    //    @NotNull
    private boolean serviced;

    //    @NotNull
    private boolean deleted;

    //    @NotNull
    private Long typeId;
}
