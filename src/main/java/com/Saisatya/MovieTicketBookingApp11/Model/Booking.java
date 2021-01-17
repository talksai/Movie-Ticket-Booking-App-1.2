package com.Saisatya.MovieTicketBookingApp11.Model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private Date bookingTime;

    @Column(name = "number_of_seat")
    private int numberOfSeats;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "show_id")
    private Show show;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Booking(Date bookingTime, int numberOfSeats, String userName, Show show) {
        this.bookingTime = bookingTime;
        this.numberOfSeats = numberOfSeats;
        this.userName = userName;
        this.show = show;
    }

    public Booking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }



    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Show getBookedShow() {
        return show;
    }

    public void setBookedShow(Show bookedShow) {
        this.show = bookedShow;
    }
}
