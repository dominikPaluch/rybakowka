package com.backend.rybakowka.model;

import com.backend.rybakowka.dto.BookedServicesDto;
import com.backend.rybakowka.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
public class BookedServices {

    public BookedServices(BookedServicesDto bookedServicesDto) {
        this.reservationId = bookedServicesDto.getReservationId();
        this.equipmentId = bookedServicesDto.getEquipmentId();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long reservationId;

    @NotNull
    private Long equipmentId;
}
