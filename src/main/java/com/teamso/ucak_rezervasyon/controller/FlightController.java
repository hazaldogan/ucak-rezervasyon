package com.teamso.ucak_rezervasyon.controller;

import com.teamso.ucak_rezervasyon.entity.Flight;
import com.teamso.ucak_rezervasyon.entity.Seat;
import com.teamso.ucak_rezervasyon.validation.ReservationValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private Map<Integer, Flight> flightMap;

    @PostConstruct
    public void init(){flightMap = new HashMap<>();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> findAll(){
        return this.flightMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Flight find(@PathVariable("id") Integer id){
        ReservationValidation.isIdValid(id);
        ReservationValidation.checkFlightExistence(flightMap,id,true);
        return flightMap.get(id);
    }

    @PostMapping
    public Flight save(@RequestBody Flight flight){
        ReservationValidation.checkFlightExistence(flightMap, flight.getId(), false);
        flightMap.put(flight.getId(),flight);
        List<Seat> seatList = flight.getSeatList();
        if(seatList != null){
            for(Seat seat: seatList){
                flight.addSeat(seat);
            }
        }
        return flightMap.get(flight.getId());
    }

    @PutMapping("/{id}")
    public Flight update(@PathVariable("id") Integer id, @RequestBody Flight flight){
        ReservationValidation.isIdValid(id);
        flight.setId(id);
        if(flightMap.containsKey(id)){
            flightMap.put(id,flight);
            return flightMap.get(id);
        }else{
            return save(flight);
        }

    }

    @DeleteMapping("/{id}")
    public Flight delete(@PathVariable("id") Integer id){
        ReservationValidation.isIdValid(id);
        ReservationValidation.checkFlightExistence(flightMap,id,true);
        return flightMap.remove(id);
    }
}
