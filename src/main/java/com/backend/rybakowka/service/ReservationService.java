package com.backend.rybakowka.service;

import com.backend.rybakowka.dto.ReservationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {

    List<ReservationDto> getListReservation();

    ReservationDto findReservationById(Long id);

    ReservationDto save(ReservationDto reservationDto);

    ReservationDto update(ReservationDto reservationDto);

    ResponseEntity delete(Long id);
}
