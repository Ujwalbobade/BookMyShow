package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTOs.AddSeatReqDTO;
import com.example.BookMyShow.DTOs.AddSeatResDTO;
import com.example.BookMyShow.Models.Seat;
import com.example.BookMyShow.Service.AddSeat;
import com.example.BookMyShow.Service.SeatService;

public class SeatController {
    private SeatService seatService;
    private AddSeat addSeat;

    SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    public AddSeatResDTO addSeats(AddSeatReqDTO addSeatReqDTO) {
        AddSeatResDTO addSeatResDTO= new AddSeatResDTO();
        try {
            Seat seat=addSeat.ToAddSeats(addSeatReqDTO.getTotalSeats(),addSeatReqDTO.getSeatType());
        } catch (Exception e) {
          e.getMessage();
        }
        return null;
    }
}
