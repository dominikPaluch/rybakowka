package com.backend.rybakowka.model;

import com.backend.rybakowka.dto.PriceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Currency;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    public Price(PriceDto priceDto) {
        this.value = priceDto.getValue();
        this.isSeazon = priceDto.isSeazon();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;

    private boolean isSeazon;

//    private Long typeId;

    public PriceDto toDto() {
        return  PriceDto.builder()
                .value(this.value)
                .isSeazon(this.isSeazon)
                .build();
    }
}
