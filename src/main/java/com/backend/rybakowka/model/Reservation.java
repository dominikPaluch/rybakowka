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

    //    @NotNull
    private Date start;

    //    @NotNull
    private Date stop;

    //    @NotNull
    private String writtenOpinion;

    //    @NotNull
    private int numericalOpinion;

//    //    @NotNull
//    private boolean deleted;
//    //
////    @NotNull
//    private boolean archived;
//
//    private boolean released;
//
//    private Long accountId;

    public ReservationDto toDto() {
        return ReservationDto.builder()
                .start(this.start)
                .stop(this.stop)
                .writtenOpinion(this.writtenOpinion)
                .numericalOpinion(this.numericalOpinion)
                .build();
    }
}
