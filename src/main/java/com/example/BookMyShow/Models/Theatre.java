package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Theatre extends BaseModel{
        private String name;
        @ManyToOne
        private Region region;
        @OneToMany
        private List<Screen> Screens;
        }

        //Theatre -->>----Movie--->>show->>>Screens-->>-->>Showseat-->>>Showseattype---