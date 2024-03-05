package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTOs.BookmovieRequestDTO;
import com.example.BookMyShow.DTOs.BookmovieResponseDTO;
import com.example.BookMyShow.DTOs.ResponseStatus;
import com.example.BookMyShow.Models.Booking;
import com.example.BookMyShow.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    //coonsturtor
    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    public BookmovieResponseDTO BookTicket(BookmovieRequestDTO bookmovieRequestDTO){
        BookmovieResponseDTO response = new BookmovieResponseDTO();
        try{
            Booking booking=bookingService.Bookticket(bookmovieRequestDTO.getShoeseatIds(),
                    bookmovieRequestDTO.getShowid(), bookmovieRequestDTO.getUserid());

            //use response builder by usiung lombok accessor chain true
            response.setBookingID(booking.getId()).setAmount(booking.getAmount()).setResponseStatus(ResponseStatus.SUCCESS);
            /*response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);*/
        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
