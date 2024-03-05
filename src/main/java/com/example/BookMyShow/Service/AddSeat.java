package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.Seat;
import com.example.BookMyShow.Models.SeatType;
import org.springframework.beans.factory.annotation.Autowired;

public class AddSeat {
    private  SeatService seatService;

    @Autowired
    public AddSeat(SeatService seatService) {
        this.seatService = seatService;
    }


    public Seat ToAddSeats(int totalSeats, SeatType seatType) {
        int seatsPerRow = 12;
        int seatNumber = 1;

        for (int i = 0; i < totalSeats; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber(String.valueOf(seatNumber));
            seat.setSeatType(seatType);
            seat.setRowVal(rowForSeat(seatNumber, seatsPerRow));
            seat.setColumnVal(columnForSeat(seatNumber, seatsPerRow));

            seatService.addSeat(seat);

            seatNumber++;
        }
        return null;
    }

    private int rowForSeat(int seatNumber, int seatsPerRow) {
        return (seatNumber - 1) / seatsPerRow + 1;
    }

    private int columnForSeat(int seatNumber, int seatsPerRow) {
        return (seatNumber - 1) % seatsPerRow + 1;
    }
}
