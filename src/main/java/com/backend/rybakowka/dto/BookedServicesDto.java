package com.backend.rybakowka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookedServicesDto {

    @NotNull
    private Long reservationId;

    @NotNull
    private Long equipmentId;

}
