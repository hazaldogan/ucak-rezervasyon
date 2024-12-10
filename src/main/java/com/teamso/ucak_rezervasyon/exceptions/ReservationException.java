package com.teamso.ucak_rezervasyon.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ReservationException extends RuntimeException {
    private HttpStatus httpStatus;

    public ReservationException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}
