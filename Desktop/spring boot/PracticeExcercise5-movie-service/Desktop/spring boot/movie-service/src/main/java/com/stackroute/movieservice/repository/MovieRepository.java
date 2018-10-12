package com.stackroute.movieservice.repository;

import com.stackroute.movieservice.domain.Movie;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {
//    @Query(value="select * from MOVIE o where o.movie=:movie")
//    public List<Movie> getMovieByTitle(@Param("movie") String movie);
}
