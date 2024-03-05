package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    private int rowVal;
    private int columnVal;
    @ManyToOne
    private SeatType seatType;

}
