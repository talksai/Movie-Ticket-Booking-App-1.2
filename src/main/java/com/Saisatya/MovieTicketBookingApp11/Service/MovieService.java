package com.Saisatya.MovieTicketBookingApp11.Service;

import com.Saisatya.MovieTicketBookingApp11.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface MovieService {
    public List<Movie> getAllMovies();
    public Movie getOneMovies(int id);
}
