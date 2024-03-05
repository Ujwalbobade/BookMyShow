package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repositories.BookingRepository;
import com.example.BookMyShow.Repositories.ShowRepository;
import com.example.BookMyShow.Repositories.ShowSeatRepository;
import com.example.BookMyShow.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
/*1 get a user with  userID
  2 get the corresponding show with showid
  -----------take lock-----
  3 get the showseat with showseatID
  4 check if the all the hsow seat are avilable
  5 if no throw an error
  if yes mark all the show seats as blocked
  update show seats in table
  --------release the lock

  create the booking obj  and the details
  save obj it in db
   return obj
  */

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;

    @Autowired
    BookingService(UserRepository userRepository,
                   ShowRepository showRepository,
                   ShowSeatRepository showSeatRepository,
    BookingRepository bookingRepository){
        this.userRepository=userRepository;
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
        this.bookingRepository=bookingRepository;
    }

    //@Transactional(Isolation.SERIALIZABLE)
    //@Transactional(isolation = Isolation.SERIALIZABLE, timeout = 30)
    public Booking Bookticket(List<Long> showseatid,
                              Long showId,
                              Long userId)
    {
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("user is not found");
        }
        User bookedby = userOptional.get();

        //eved frecirom DB
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("show doesnt exist");
        }
        Show savedshow = showOptional.get();

        //recieved from DB
        List<ShowSeat> Showseatlist = showSeatRepository.findAllById(showseatid);
        Showseatlist.forEach(i -> {
            if (!(i.getShowseatStatus().equals(ShowseatStatus.EMPTY) ||
                    (i.getShowseatStatus().equals(ShowseatStatus.BLOCKED) &&
                            Duration.between(i.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes() > 15))) {
                throw new RuntimeException("Not all selected seats are available");
            }
        });
        Showseatlist.forEach(i->{
            i.setShowseatStatus(ShowseatStatus.BLOCKED);
            i.setBlockedAt(new Date());
            showSeatRepository.save(i);
        });
        Booking booking = new Booking();
        booking.setBookedAt(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShow(savedshow);
        booking.setUser(bookedby);
        booking.setShowSeats(Showseatlist);
        booking.setAmount(0);
        booking.setPayments(new ArrayList<>());
        //saved booking obj in DB
        bookingRepository.save(booking);


        //return the booking obj
        return booking;

    }
}
