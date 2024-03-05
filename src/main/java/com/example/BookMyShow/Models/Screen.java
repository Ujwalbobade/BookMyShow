package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String Name;//Screen name
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection //collection of enums  may create mapping table
    private List<Feature> MovieType;




}
