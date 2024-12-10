package com.teamso.ucak_rezervasyon.entity;

import lombok.Data;

@Data
public class Seat {
    private int id;
    private String name;
    private boolean isEmpty;
    private Flight flight;
}
