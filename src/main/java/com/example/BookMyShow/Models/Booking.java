package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToMany
    private List<ShowSeat> showSeats;
    //1 : M : one booking will have many showseaT
    //m : 1  : ONE SHOSEAT can be p
    // resent in multiple bopoking -> when it get rebooked

    //1 : 1
    //m  : 1
    @ManyToOne
    private User user;
    private Date bookedAt;

    //1: 1
    //m:1
    @ManyToOne
    private Show show;

    private int amount;
    //1:M
    //1:1
    @OneToMany
    private List<Payment> payments;
}
