package com.Saisatya.MovieTicketBookingApp11.Controller;

import com.Saisatya.MovieTicketBookingApp11.Exception.BookingNotFound;
import com.Saisatya.MovieTicketBookingApp11.Exception.MovieNotFoundException;
import com.Saisatya.MovieTicketBookingApp11.Model.Booking;
import com.Saisatya.MovieTicketBookingApp11.Model.Movie;
import com.Saisatya.MovieTicketBookingApp11.Model.Show;
import com.Saisatya.MovieTicketBookingApp11.Service.BookingService;
import com.Saisatya.MovieTicketBookingApp11.Service.MovieService;
import com.Saisatya.MovieTicketBookingApp11.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeCcontroller {


    @Autowired
    MovieService movieService;
    @Autowired
    ShowService showService;
    @Autowired
    BookingService bookingService;

    //unregistered user
    @GetMapping("/")
    public String home(){

        return  "\n" +
                "<h1>Movie-Ticket-Booking-Application</h1>\n" +
                "<a href=\"/movies\">All Movie</a>\n" +
                "<br>\n" +
                "<a href=\"/shows\">All Shows</a>";
    }


    @GetMapping("/movies")
    public List<Movie> movieList(){
        if(movieService.getAllMovies()==null){
            throw new MovieNotFoundException();
        }
        return  movieService.getAllMovies();
    }
    @GetMapping("/movies/{id}")
    public Movie getOneMovie(@PathVariable int id){

        return  movieService.getOneMovies(id);
    }
    @GetMapping("/shows")
    public List<Show> ShowList(){

        return showService.getAllShows();
    }
    @GetMapping("/shows/{id}")
    public Show getOneShow(@PathVariable int id){

        return  showService.getOneSshow(id);
    }
    @GetMapping("/movies/{id}/shows")
    public List<Show> getShowsByMovie(@PathVariable int id){

        return  showService.findByMovie(id);
    }
    //registered user   --------Booking
    @PostMapping(name = "/shows/{id}/booking")
    public String Booking(@PathVariable int id, @RequestParam Booking booking){
        Show show= showService.getOneSshow(id);
        bookingService.saveBooking(show,booking);

        return  "sucess";
    }

    //get all booking
    @GetMapping("/bookinglist")
    public List<Booking> getBookingList(){
        List<Booking> bookings= bookingService.getBookingList();
        if(bookings==null){
            throw new BookingNotFound();
        }

        return  bookings;
    }



}
