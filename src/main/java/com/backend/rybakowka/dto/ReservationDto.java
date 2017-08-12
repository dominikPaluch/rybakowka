package com.backend.rybakowka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

//    @NotNull
    private Date start;

//    @NotNull
    private Date stop;

//    @NotNull
    private String writtenOpinion;

//    @NotNull
    private int numericalOpinion;

//    @NotNull
    private boolean deleted;
    //
//    @NotNull
    private boolean archived;

    private boolean released;

    private Long accountId;
}
