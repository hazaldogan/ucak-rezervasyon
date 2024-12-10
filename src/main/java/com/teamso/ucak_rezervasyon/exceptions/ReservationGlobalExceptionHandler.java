package com.teamso.ucak_rezervasyon.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ReservationGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(ReservationException reservationException){
        log.error("ReservationException occured! Exception detail: " + reservationException.getMessage());
        ReservationErrorResponse reservationErrorResponse = new ReservationErrorResponse(reservationException.getHttpStatus().value(),
                reservationException.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(reservationErrorResponse,reservationException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(Exception exception){
        log.error("Exception occured! Exception details: " + exception.getMessage());
        ReservationErrorResponse reservationErrorResponse = new ReservationErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(reservationErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
