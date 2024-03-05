package com.example.BookMyShow.DTOs;

import com.example.BookMyShow.Models.SeatType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
@Getter
@Controller
@Setter
public class AddSeatReqDTO {
    private int TotalSeats;
    private SeatType seatType;

}
