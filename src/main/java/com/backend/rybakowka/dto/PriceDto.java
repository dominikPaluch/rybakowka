package com.backend.rybakowka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Currency;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {

    @Id
    private Long id;

    private double value;

    private boolean isSeazon;

//    private Long typeId;
}
