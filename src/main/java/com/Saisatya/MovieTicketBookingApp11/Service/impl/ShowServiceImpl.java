package com.Saisatya.MovieTicketBookingApp11.Service.impl;

import com.Saisatya.MovieTicketBookingApp11.Dao.ShowsDao;
import com.Saisatya.MovieTicketBookingApp11.Exception.ShowNotFound;

import com.Saisatya.MovieTicketBookingApp11.Model.Show;
import com.Saisatya.MovieTicketBookingApp11.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowsDao showsDao;
    @Override
    public List<Show> getAllShows() {
        return showsDao.findAll();
    }

    @Override
    public Show getOneSshow(int id) {
        Optional<Show> show=showsDao.findById(id);
        if(!show.isPresent()){
            throw new ShowNotFound();
        }
        return show.get();
    }

    @Override
    public List<Show> findByMovie(int movieId) {
        if(showsDao.findByMovie(movieId)==null){
            throw new ShowNotFound();
        }
        return showsDao.findByMovie(movieId);
    }

    @Override
    public void save(Show show) {
        showsDao.save(show);
    }
}
