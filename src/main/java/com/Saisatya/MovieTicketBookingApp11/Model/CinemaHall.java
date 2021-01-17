package com.Saisatya.MovieTicketBookingApp11.Model;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinema_hall")

public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer cinemaHallId;
    @Column(name = "name")
    private String cinemaHallName;
    @Column(name = "capacity")
    private int capacity;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Address address;

   @OneToMany(mappedBy="cinemaHalo",
          cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Show> shows;

    public CinemaHall(String cinemaHallName, Address address, int capacity) {
        this.cinemaHallName = cinemaHallName;
        this.address = address;
        this.capacity = capacity;

    }

    public CinemaHall() {
    }

    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getCinemaHallName() {
        return cinemaHallName;
    }

    public void setCinemaHallName(String cinemaHallName) {
        this.cinemaHallName = cinemaHallName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public void addShows(Show show) {
        if(shows.isEmpty()){
            shows=new ArrayList<>();
        }
        shows.add(show);
        show.setCinemaHall(this);
    }
}
