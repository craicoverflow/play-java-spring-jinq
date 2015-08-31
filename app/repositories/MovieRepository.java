package repositories;

import models.Movie;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by enda on 31/08/15.
 */
@Named
@Singleton
public interface MovieRepository {
    Movie addMovie(Movie movie);
    List<Movie> getMoviesWithTitle(String title);
    List<Movie> getAllMovies();

}