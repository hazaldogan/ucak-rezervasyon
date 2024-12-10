package com.teamso.ucak_rezervasyon.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reservation {
    private int id;
    private String fullname;
    private Flight flight;
    private Seat seat;
    private LocalDateTime datetime;
}
