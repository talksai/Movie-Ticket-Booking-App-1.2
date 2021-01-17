package com.Saisatya.MovieTicketBookingApp11.Service.impl;

import com.Saisatya.MovieTicketBookingApp11.Dao.MovieDao;
import com.Saisatya.MovieTicketBookingApp11.Exception.MovieNotFoundException;
import com.Saisatya.MovieTicketBookingApp11.Model.Movie;
import com.Saisatya.MovieTicketBookingApp11.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDao movieDao;

    @Override
    public Movie getOneMovies(int id) {
        Optional<Movie> movie=movieDao.findById(id);
        if(!movie.isPresent()){
            throw new MovieNotFoundException();
        }
        Movie movie1=movie.get();

        return movie.get();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }
}
