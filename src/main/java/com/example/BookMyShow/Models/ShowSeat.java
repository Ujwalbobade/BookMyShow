package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;

    private ShowseatStatus showseatStatus;

     private Date blockedAt;
}
/*
showseat to shows
1 : 1
m : 1


show  seat  status
1      5     ....  one shoseatobj
1      6     ....
1      7      .....
2      5      ....
3       5     ....
*/
