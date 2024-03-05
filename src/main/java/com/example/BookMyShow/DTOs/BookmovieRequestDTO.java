package com.example.BookMyShow.DTOs;

import com.example.BookMyShow.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookmovieRequestDTO {
    private List<Long> ShoeseatIds;

    private Long showid;

    private Long userid;
}
