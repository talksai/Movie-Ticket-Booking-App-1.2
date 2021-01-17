package com.Saisatya.MovieTicketBookingApp11.Dao;

import com.Saisatya.MovieTicketBookingApp11.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowsDao extends JpaRepository<Show,Integer> {
    public List<Show> findByMovie(int movieId);
}
