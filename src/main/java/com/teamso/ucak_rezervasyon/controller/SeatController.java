package com.teamso.ucak_rezervasyon.controller;

import com.teamso.ucak_rezervasyon.entity.Seat;
import com.teamso.ucak_rezervasyon.validation.ReservationValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private Map<Integer, Seat> seatMap;

    @PostConstruct
    public void init(){ seatMap = new HashMap<>();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Seat> findAll(){
        return this.seatMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Seat find(@PathVariable("id") Integer id){
        ReservationValidation.isIdValid(id);
        return seatMap.get(id);
    }

    @PostMapping
    public Seat save(@RequestBody Seat seat){
        seatMap.put(seat.getId(),seat);
        return seatMap.get(seat.getId());
    }

    @PutMapping("/{id}")
    public Seat update(@PathVariable("id") Integer id, @RequestBody Seat seat){
        ReservationValidation.isIdValid(id);
        seat.setId(id);
        if(seatMap.containsKey(id)){
            seatMap.put(id, seat);
            return seatMap.get(id);
        }else{
            return save(seat);
        }
    }

    @DeleteMapping("/{id}")
    public Seat delete(@PathVariable("id") Integer id){
        ReservationValidation.isIdValid(id);
        return seatMap.remove(id);
    }
}
