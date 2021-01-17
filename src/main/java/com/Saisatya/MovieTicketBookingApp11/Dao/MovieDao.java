package com.Saisatya.MovieTicketBookingApp11.Dao;

import com.Saisatya.MovieTicketBookingApp11.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie,Integer> {
}
