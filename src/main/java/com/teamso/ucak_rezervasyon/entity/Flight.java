package com.teamso.ucak_rezervasyon.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Flight {
    private int id;
    private String name;
    private String description;
    private double price;
    private List<Seat> seatList;

    public void addSeat(Seat seat){
        if(seatList == null){
            seatList = new ArrayList<>();
        }
        seatList.add(seat);
    }
}
