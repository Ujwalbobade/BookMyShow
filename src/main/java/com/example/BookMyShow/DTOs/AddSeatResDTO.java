package com.example.BookMyShow.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Setter@Getter
public class AddSeatResDTO {
    private ResponseStatus responseStatus;

    private int TotalSeatadded;
}
