package com.teamso.ucak_rezervasyon.validation;

import com.teamso.ucak_rezervasyon.entity.Flight;
import com.teamso.ucak_rezervasyon.exceptions.ReservationException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ReservationValidation {
    public static void isIdValid(Integer id){
        if(id == null || id<0){
            throw new ReservationException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkFlightExistence(Map<Integer, Flight> flightMap, int id, boolean shouldbeExist){
        if(shouldbeExist){
            if(!flightMap.containsKey(id)){
                throw new ReservationException("Id is not exist: " + id, HttpStatus.NOT_FOUND);
            }
        }else{
            if(flightMap.containsKey(id)){
                throw new ReservationException("Id already exist: " + id, HttpStatus.BAD_REQUEST);
            }
        }
    }
}
