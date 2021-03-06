package com.stackroute.movieservice.domain;

//import org.hibernate.mapping.Collection;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Document(collection="test")
public class Movie {
    @Id
    @NotNull
    private int id;
    private String movie;
    private String comments;

    public Movie() {
    }

    public Movie(int Id,String movie, String comments) {
        this.movie = movie;
        this.id=Id;
        this.comments = comments;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
