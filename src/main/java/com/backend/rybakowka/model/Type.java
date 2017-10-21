package com.backend.rybakowka.model;

import com.backend.rybakowka.dto.TypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    public Type(TypeDto typeDto) {
        this.id = typeDto.getId();
        this.name = typeDto.getName();
        this.description = typeDto.getDescription();
        this.normalPrice = typeDto.getNormalPrice();
        this.seasonPrice = typeDto.getSeasonPrice();
        this.isDeleted = typeDto.isDeleted();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String  name;

    @NotNull
    private String  description;

    @NotNull
    private double  normalPrice;

    @NotNull
    private double  seasonPrice;

    @NotNull
    private boolean  isDeleted;

    public TypeDto toDto() {
        return  TypeDto.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .normalPrice(this.normalPrice)
                .seasonPrice(this.seasonPrice)
                .isDeleted(this.isDeleted)
                .build();
    }
}
