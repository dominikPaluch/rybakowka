package com.backend.rybakowka.conrtoller;

import com.backend.rybakowka.dto.ReservationDto;
import com.backend.rybakowka.model.Reservation;
import com.backend.rybakowka.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationDto> getListReservation() {
        return reservationService.getListReservation();
    }

    @GetMapping(value = "/{id}")
    public ReservationDto findAccountById(@PathVariable Long id) {
        return reservationService.findReservationById(id);
    }

    @PostMapping()
    public @ResponseBody
    ReservationDto save(@RequestBody @Valid ReservationDto reservationDto) {
        reservationService.save(reservationDto);

        return reservationDto;
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody
    ReservationDto update(@PathVariable("id") Long id, @RequestBody ReservationDto reservationDto) {
        reservationService.update(reservationDto);
        return reservationDto;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return reservationService.delete(id);
    }
}
