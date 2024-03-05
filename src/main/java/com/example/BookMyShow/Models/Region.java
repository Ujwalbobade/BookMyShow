package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Region extends BaseModel{
   private String name;
    @OneToMany
    private List<Theatre> TheatreList;
/*    @ManyToMany
    private List<Movie> listofmovie;*/
}

