package com.Saisatya.MovieTicketBookingApp11.Service.impl;

import com.Saisatya.MovieTicketBookingApp11.Dao.BookingDao;
import com.Saisatya.MovieTicketBookingApp11.Exception.SeatNotAvalException;
import com.Saisatya.MovieTicketBookingApp11.Model.Booking;
import com.Saisatya.MovieTicketBookingApp11.Model.Show;
import com.Saisatya.MovieTicketBookingApp11.Service.BookingService;
import com.Saisatya.MovieTicketBookingApp11.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service

public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingDao bookingDao;
    @Autowired
    ShowService showService;
    @Autowired
    GetUserName getUserName;
    @Autowired
    Payment payment;


    @Override
    public List<Booking> getBookingList() {
        return bookingDao.findByUserName(getUserName.getUserName());
    }

    @Override
    public String saveBooking(Show show , Booking booking) {
        if(payment.paymennt()) {
            Booking booking1 = booking;
            long miles = System.currentTimeMillis();
            Date date = new Date(miles);
            booking1.setBookingTime(date);

            if (show.getAvailableSeats() <= 0 || show.getAvailableSeats() - booking.getNumberOfSeats() < 0) {
                throw new SeatNotAvalException();
            }

            show.setAvailableSeats(show.getAvailableSeats() - booking.getNumberOfSeats());
            showService.save(show);
            booking1.setBookedShow(show);
            booking.setUserName(getUserName.getUserName());
            bookingDao.save(booking1);
        }
        else {
            return "Payment fail";
        }
        return "Payment Sucess";





    }
}
