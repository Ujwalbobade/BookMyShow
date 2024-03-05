package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.ShowSeat;
import com.example.BookMyShow.Models.ShowSeatType;
import com.example.BookMyShow.Repositories.ShowSeatTypeRepository;

import java.util.List;
/*we get list of seat from user  and show name , and user id */
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTyperepo;

    PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepo){
        this.showSeatTyperepo=showSeatTypeRepo;
    }
    public int CalculatePrice(List<ShowSeat> showseat, Show show){
        List<ShowSeatType> showSeatTypes =showSeatTyperepo.findAllByShow(show);
        int amount=0;
        for(ShowSeat s : showseat){//total seat
        for(ShowSeatType showSeatType1 : showSeatTypes){//all seat type for that show
            if(s.getSeat().getSeatType().equals(showSeatType1.getSeatType())) {//matching type and thier amount
                amount += showSeatType1.getPrice();
            }
            }
        }
        return amount;
    }
}
