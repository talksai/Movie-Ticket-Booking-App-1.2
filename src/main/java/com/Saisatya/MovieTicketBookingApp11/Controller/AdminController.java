package com.Saisatya.MovieTicketBookingApp11.Controller;


import com.Saisatya.MovieTicketBookingApp11.Dao.AdressDao;
import com.Saisatya.MovieTicketBookingApp11.Dao.CinemaHallDao;
import com.Saisatya.MovieTicketBookingApp11.Dao.MovieDao;
import com.Saisatya.MovieTicketBookingApp11.Dao.ShowsDao;

import com.Saisatya.MovieTicketBookingApp11.Model.CinemaHall;
import com.Saisatya.MovieTicketBookingApp11.Model.Movie;
import com.Saisatya.MovieTicketBookingApp11.Model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class AdminController {

    @Autowired
    CinemaHallDao cinemaHallDao;
    @Autowired
    AdressDao adressDao;
    @Autowired
    ShowsDao showsDao;
    @Autowired
    MovieDao movieDao;

    @PostMapping(path = "/admin/cinemahal")
    public String addCinemaHall( @RequestBody CinemaHall cinemaHall){
        cinemaHallDao.save(cinemaHall);
        adressDao.save(cinemaHall.getAddress());


        return  "sucess";
    }
    @GetMapping(path = "/admin/cinemahall")
    public List<CinemaHall> getCinemaHall( ){
        return cinemaHallDao.findAll();

    }
    @GetMapping(path = "/admin/cinemahall/{id}")
    public CinemaHall getOneCinemaHall(@PathVariable int id ) throws Exception {
        Optional<CinemaHall> cinemaHall=cinemaHallDao.findById(id);
        if(cinemaHall.isEmpty()){
            throw new Exception("cinema hall not found");
        }
        return cinemaHall.get();

    }
    @DeleteMapping(path = "/admin/cinemahall/{id}")
    public String deleteOneCinemaHall(@PathVariable int id ) throws Exception {
        Optional<CinemaHall> cinemaHall=cinemaHallDao.findById(id);
        if(cinemaHall.isEmpty()){
            throw new Exception("cinema hall not found");
        }
        cinemaHallDao.delete(cinemaHall.get());

        return "sucess";


    }
    @PostMapping(path = "/admin/cinemahall/{id}/show")
    public String addShow(@PathVariable int id, @RequestBody Show show,@RequestBody Movie movie) throws Exception {
        Optional<CinemaHall> cinemaHall2=cinemaHallDao.findById(id);
        if(cinemaHall2.isEmpty()){
            throw new Exception("cinema hall not found");
        }
        CinemaHall cinemaHall1= cinemaHall2.get();
        cinemaHall1.addShows(show);
        show.setCinemaHall(cinemaHall1);

        movie.addShows(show);
        show.setMovie(movie);
        movieDao.save(movie);
        showsDao.save(show);



        return  "sucess";
    }
    @PostMapping("/admin/movies")
    public String addMovie(@RequestBody Movie movie) {
        movieDao.save(movie);


        return "sucess";
    }
    @DeleteMapping("/admin/movies/{id}")
    public String deleteMovie(@PathVariable int id) throws Exception {
        Optional<Movie> movie=movieDao.findById(id);
        if(movie.isEmpty()){
            throw new Exception("cinema hall not found");
        }
        movieDao.delete(movie.get());


        return "sucess";
    }


}
