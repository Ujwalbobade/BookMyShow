package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.Seat;
import com.example.BookMyShow.Repositories.SeatReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatService {
    private final SeatReposiotry seatRepository;

    @Autowired
    public SeatService(SeatReposiotry seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void addSeat(Seat seat) {
        seatRepository.save(seat);
    }

    public void addSeats(List<Seat> seats) {
        seatRepository.saveAll(seats);
    }
}
