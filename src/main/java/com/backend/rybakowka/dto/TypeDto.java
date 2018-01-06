package com.backend.rybakowka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {

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

}
