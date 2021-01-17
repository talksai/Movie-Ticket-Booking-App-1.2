package com.Saisatya.MovieTicketBookingApp11.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer movieId;

    @Column(name = "name")
    private String movieName;

    @Column(name = "durection")
    private String durationInMins;


    private Language language;
    private Genre genre;

    @Column(name = "rating")
    private float rating;

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    @OneToMany(mappedBy="movie",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Show> shows;

    public Movie( String movieName, String durationInMins, Language language, Genre genre, float rating) {

        this.movieName = movieName;
        this.durationInMins = durationInMins;
        setLanguage(language);
        this.language = getLanguage();
        setGenre(genre);
        this.genre = getGenre();
        this.rating = rating;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDurationInMins() {
        return durationInMins;
    }

    public void setDurationInMins(String durationInMins) {
        this.durationInMins = durationInMins;
    }

    public Language getLanguage() {
        return language;
    }

    @Enumerated(EnumType.STRING)
    public void setLanguage(Language language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    @Enumerated(EnumType.STRING)
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    public void addShows(Show show) {
        if(shows.isEmpty()){
            shows=new ArrayList<>();
        }
        shows.add(show);
        show.setMovie(this);
    }
}
