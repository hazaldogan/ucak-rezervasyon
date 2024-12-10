package com.teamso.ucak_rezervasyon.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
