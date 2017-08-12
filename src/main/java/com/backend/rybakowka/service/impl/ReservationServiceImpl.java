package com.backend.rybakowka.service.impl;

import com.backend.rybakowka.dto.ReservationDto;
import com.backend.rybakowka.exception.ReservationException;
import com.backend.rybakowka.model.Reservation;
import com.backend.rybakowka.repository.ReservationRepository;
import com.backend.rybakowka.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public List<ReservationDto> getListReservation() {
        return reservationRepository.findAll().stream()
                .map(Reservation::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDto findReservationById(Long id) {
        return Optional.ofNullable(reservationRepository.findOne(id))
                .orElseThrow(
                        () -> new ReservationException("Reservation doesn't exist!")
                ).toDto();
    }

    @Override
    public ReservationDto save(ReservationDto reservationDto) {
        Reservation reservation = new Reservation(reservationDto);
        return reservationRepository.saveAndFlush(reservation).toDto();
    }

    @Override
    public ReservationDto update(ReservationDto reservationDto) {
        Reservation reservation = new Reservation(reservationDto);
        return reservationRepository.saveAndFlush(reservation).toDto();
    }

    @Override
    public ResponseEntity delete(Long id) {
        reservationRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}
