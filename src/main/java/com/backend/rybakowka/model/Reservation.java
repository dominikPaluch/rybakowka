package com.backend.rybakowka.model;

import com.backend.rybakowka.dto.ReservationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    public Reservation(ReservationDto reservationDto) {
        this.start = reservationDto.getStart();
        this.stop = reservationDto.getStop();
        this.writtenOpinion = reservationDto.getWrittenOpinion();
        this.numericalOpinion = reservationDto.getNumericalOpinion();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date start;

    @NotNull
    private Date stop;

    @NotNull
    private double totalPrice;

    private String writtenOpinion;

    private int numericalOpinion;

    @NotNull
    private StatusReservationEnum statusReservationEnum;

    private Long accountId;

    public ReservationDto toDto() {
        return ReservationDto.builder()
                .start(this.start)
                .stop(this.stop)
                .totalPrice(this.totalPrice)
                .writtenOpinion(this.writtenOpinion)
                .numericalOpinion(this.numericalOpinion)
                .statusReservationEnum(this.statusReservationEnum)
                .build();
    }
}
