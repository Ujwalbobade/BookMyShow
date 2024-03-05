package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity(name ="Shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date StartTime;
    private Date Endtime;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;//2d 3d 4d
    @Enumerated(EnumType.ORDINAL)
    private Showstatus showstatus;
}
