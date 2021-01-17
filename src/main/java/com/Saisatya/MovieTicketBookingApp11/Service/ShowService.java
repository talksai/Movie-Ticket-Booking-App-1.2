package com.Saisatya.MovieTicketBookingApp11.Service;

import com.Saisatya.MovieTicketBookingApp11.Model.Movie;
import com.Saisatya.MovieTicketBookingApp11.Model.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowService {
    public List<Show> getAllShows();
    public Show getOneSshow(int id);
    public List<Show> findByMovie(int MovieId);
    public void save(Show show);
}
