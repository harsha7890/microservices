package com.stackroute.movieservice.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection="movies")
public class Movie {
    @NotNull
    @Id
    private int id;
    @NotNull
    @Size(min=2, message="Comments should have atleast 2 characters")
    private String movie;
    @Size(min=2, message="Comments should have atleast 2 characters")
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
