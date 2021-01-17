package com.Saisatya.MovieTicketBookingApp11.Dao;

import com.Saisatya.MovieTicketBookingApp11.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDao extends JpaRepository<Booking,Integer> {
    public List<Booking> findByUserName(String userNmae);
}
