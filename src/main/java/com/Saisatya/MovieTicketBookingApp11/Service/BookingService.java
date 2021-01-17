package com.Saisatya.MovieTicketBookingApp11.Service;

import com.Saisatya.MovieTicketBookingApp11.Model.Booking;
import com.Saisatya.MovieTicketBookingApp11.Model.Show;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    public String saveBooking(Show show, Booking booking);
    public List<Booking> getBookingList();
}
