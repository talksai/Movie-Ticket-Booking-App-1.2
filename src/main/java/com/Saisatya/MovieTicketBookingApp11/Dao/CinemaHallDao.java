package com.Saisatya.MovieTicketBookingApp11.Dao;

import com.Saisatya.MovieTicketBookingApp11.Model.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallDao extends JpaRepository<CinemaHall,Integer> {
}
