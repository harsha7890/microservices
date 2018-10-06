package com.stackroute.movieservice;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MovieServiceApplication implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner{
		/**
		 * This event is executed as late as conceivably possible to indicate that
		 * the application is ready to service requests.
		 */

		@Autowired
		private MovieRepository movieRepository;

		@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			Movie movie = new Movie(1,"movie1","comments1");
			movieRepository.save(movie);
			Movie movie2 = new Movie(2,"movie2","comments2");
			movieRepository.save(movie2);
		}
		@Override
        public void run(String... args){
            Movie movie = new Movie(3,"movie3","comments3");
            movieRepository.save(movie);
            Movie movie2 = new Movie(4,"movie4","comments4");
            movieRepository.save(movie2);
    }



	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
}
