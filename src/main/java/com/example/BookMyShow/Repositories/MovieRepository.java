package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Override
    List<Movie> findAllById(Iterable<Long> longs);

    @Override
    Movie save(Movie entity);
}
