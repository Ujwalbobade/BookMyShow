package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {
    @Override
    Optional<Screen> findById(Long aLong);
}
