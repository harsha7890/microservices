package com.stackroute.movieservice.controller;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.UserAlreadyexists;
import com.stackroute.movieservice.exception.UserNotExists;
import com.stackroute.movieservice.service.MovieService;
import com.stackroute.movieservice.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try {
            Movie saveduser = movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<Movie>(saveduser, HttpStatus.OK);
        }
        catch (UserAlreadyexists ex){
            responseEntity = new ResponseEntity<String>("User already exists",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/movie")
    public ResponseEntity<?> getAllmovies(){
        ResponseEntity responseEntity;

            List<Movie> movieList;
            movieList = movieService.movieList();
            responseEntity = new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);


        return responseEntity;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value="id") int id){
        ResponseEntity responseEntity;
        try {
            movieService.deleteMovies(id);
            responseEntity = new ResponseEntity<Integer>(id,HttpStatus.OK);
        }
        catch (UserNotExists ex){
            responseEntity = new ResponseEntity<String>("User not found",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatemovie(@PathVariable(value="id") int id,@RequestBody String newComment){
        ResponseEntity responseEntity;
        try{
            Movie updatedmovie = movieService.updateComment(id,newComment);
            responseEntity = new ResponseEntity<Movie>(updatedmovie,HttpStatus.OK);
        }
        catch (UserNotExists ex){
            responseEntity = new ResponseEntity<String>("User not found",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/{movie}")
    public ResponseEntity<?> searchMovies(@PathVariable String movie){
        ResponseEntity responseEntity;
        try{
            List<Movie> searchedMovie = movieService.searchMovie(movie);
            responseEntity = new ResponseEntity<List<Movie>>(searchedMovie,HttpStatus.OK);
        }
        catch (UserNotExists ex){
            responseEntity = new ResponseEntity<String>("user not found",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/query/{movie}")
    public ResponseEntity<?> searchMoviesQuery(@PathVariable("movie") String movie){
        ResponseEntity responseEntity;
            List<Movie> listMovies = movieService.searchByMovieQuery(movie);
            responseEntity = new ResponseEntity<List<Movie>>(listMovies,HttpStatus.OK);
        return responseEntity;
    }
}
