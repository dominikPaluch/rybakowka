package com.backend.rybakowka.model;


import com.backend.rybakowka.dto.EquipmentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    public Equipment(EquipmentDto equipmentDto) {
        this.inStock = equipmentDto.isInStock();
        this.serviced = equipmentDto.isServiced();
        this.deleted = equipmentDto.isDeleted();
    }

    @Id
    private Long id;

    //    @NotNull
    private boolean inStock;

    //    @NotNull
    private boolean serviced;

    //    @NotNull
    private boolean deleted;

//    //    @NotNull
//    private Long typeId;

    public EquipmentDto toDto() {
        return  EquipmentDto.builder()
                .inStock(this.inStock)
                .serviced(this.serviced)
                .deleted(this.deleted)
                .build();
    }

}
