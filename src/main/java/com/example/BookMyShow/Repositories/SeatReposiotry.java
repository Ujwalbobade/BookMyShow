package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatReposiotry extends JpaRepository<Seat,Long> {
    @Override
    Optional<Seat> findById(Long aLong);
}
