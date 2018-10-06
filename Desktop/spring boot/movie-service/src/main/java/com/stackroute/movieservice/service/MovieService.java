package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.UserAlreadyexists;
import com.stackroute.movieservice.exception.UserNotExists;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {
    public Movie saveMovie(Movie movie) throws UserAlreadyexists;
    public Movie updateComment(int Id,String newComment) throws UserNotExists ;
    public void deleteMovies(int Id) throws UserNotExists;
    public List<Movie> movieList();
    public List<Movie> searchMovie(String movies) throws UserNotExists ;
    public List<Movie> searchByMovieQuery(String movie);
}
