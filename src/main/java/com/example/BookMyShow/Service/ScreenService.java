package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.Screen;
import com.example.BookMyShow.Models.Seat;
import com.example.BookMyShow.Models.SeatType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScreenService {
    private  SeatService seatService;

    @Autowired
    public ScreenService(SeatService seatService) {
        this.seatService = seatService;
    }

    /*public void ToAddSeats(int totalseat, SeatType seatType) {
        int seatno=0;int row=0;int col=0;
        for(int i=0;i<totalseat;i++){
            Seat seat1 = new Seat();
            seat1.setSeatNumber();
            seat1.setSeatType(seatType);
            seat1.setRowVal();
            seat1.setColumnVal();
            seatService.addSeat(seat1);
        }

         Set seat properties

        Seat seat2 = new Seat();
        // Set seat properties

        // Add seats using the SeatService

        seatService.addSeat(seat2);
    }*/
    //every row contain 12 seats
    public List<Seat> ToAddSeats(int totalSeats, SeatType seatType) {
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
