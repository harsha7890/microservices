package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.UserAlreadyexists;
import com.stackroute.movieservice.exception.UserNotExists;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;


    public Movie saveMovie(Movie movie) throws UserAlreadyexists {
        if(movieRepository.existsById(movie.getId())){
            throw new UserAlreadyexists("user not found");
        }
        else {
            Movie savedMoive = movieRepository.save(movie);
            return savedMoive;
        }
    }
    public List<Movie> movieList()  {

        List<Movie> listmovies = (List)movieRepository.findAll();

         return listmovies;

    }
    public Movie updateComment(int id,String newComment) throws UserNotExists{
        List<Movie> movieList = movieList();
        int j=0;
        if(!movieRepository.existsById(id)){
            throw new UserNotExists("user not found");
        }
        else {
        for(int i=0;i<movieList.size();i++){
                if (movieList.get(i).getId()==id) {
                    movieList.get(i).setComments(newComment);
                    movieRepository.save(movieList.get(i));
                    j = i;
                }
            }
        }

        return movieList.get(j);
    }
    public void deleteMovies(int id) throws UserNotExists{
        List<Movie> listMovies = movieList();
        if(movieRepository.existsById(id)){
            for (int i = 0; i < listMovies.size(); i++) {
                if (listMovies.get(i).getId()==(id)) {
                    movieRepository.delete(listMovies.get(i));
                }
            }
        }
        else {
            throw new UserNotExists("user not found");
        }
//        movieRepository.delete(movie);
    }

    public List<Movie> searchMovie(String movies) throws UserNotExists {
       List<Movie> listMovies = movieList();
       List<Movie> searchmovie= new ArrayList<>();
       int j=-1;
       for(int i=0;i<listMovies.size();i++){
               if(listMovies.get(i).getMovie().equals(movies)){
                   searchmovie.add(listMovies.get(i));
                   j=i;
               }
       }
       if(j==-1){
           throw new UserNotExists("user not found");
       }
       else{
           return searchmovie;
       }

    }
//    public List<Movie> searchByMovieQuery(String movie){
//        return (List)movieRepository.getMovieByTitle(movie);
//    }
}
