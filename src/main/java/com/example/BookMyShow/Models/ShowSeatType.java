package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;

    private int price;

}
/*
SHOW SEATYPE PRICE
1       gold       200RS
2        gold       2000
1     platinum       230
*/
