package com.teamso.ucak_rezervasyon.controller;

import com.teamso.ucak_rezervasyon.entity.Reservation;
import com.teamso.ucak_rezervasyon.exceptions.ReservationException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private Map<Integer, Reservation> reservationMap;

    @PostConstruct
    public void init(){reservationMap=new HashMap<>();}

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation){
        if(reservation.getSeat().isEmpty()){
            reservationMap.put(reservation.getId(),reservation);
            return reservationMap.get(reservation.getId());
        }else{
            throw new ReservationException("Selected seat is full: " + reservation.getSeat().getId(), HttpStatus.BAD_REQUEST);
        }

    }
}
