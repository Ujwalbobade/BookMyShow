package com.example.BookMyShow.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class BookmovieResponseDTO {
    private ResponseStatus responseStatus;
    private int amount;
    //this booking is not finalize yer
    //it will be finalized once the payment is done

    private Long bookingID;

}
