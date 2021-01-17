package com.Saisatya.MovieTicketBookingApp11.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "showtime")
    private java.sql.Date showTime;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "movie_id")
    private Movie movie;


    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "cinemahall_id")
    private CinemaHall cinemaHalo;




    @OneToMany(mappedBy="show",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Booking> bookings;

    @Column(name = "avalialable_seats")
    private int availableSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getShowTime() {
        return showTime;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHalo;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHalo = cinemaHall;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShowTime(java.sql.Date showTime) {
        this.showTime = showTime;
    }

    public Show(java.sql.Date showTime, Movie movie, CinemaHall cinemaHall, List<Booking> bookings, int availableSeats) {
        this.showTime = showTime;
        this.movie = movie;
        this.cinemaHalo = cinemaHall;
        this.bookings = bookings;
        this.availableSeats = availableSeats;
    }

    public Show() {
    }

    public void addShows(Booking booking) {
        if(bookings.isEmpty()){
            bookings=new ArrayList<>();
        }
        bookings.add(booking);
        booking.setBookedShow(this);
    }
}
