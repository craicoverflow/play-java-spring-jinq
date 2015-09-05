package controllers;

import models.Movie;
import org.springframework.stereotype.Controller;
import play.data.Form;
import play.mvc.Result;
import repositories.MovieRepository;
import java.util.List;
import views.html.index;

import javax.inject.Inject;
import javax.inject.Singleton;

import static play.libs.Json.toJson;
import static play.mvc.Results.notFound;
import static play.mvc.Results.ok;

/**
 * Created by enda on 31/08/15.
 */
@Controller
@Singleton
public class MoviesController {

    private final MovieRepository repo;

    @Inject
    public MoviesController(MovieRepository repo) {
        this.repo = repo;
    }

    public Result index() {
        return ok(index.render(Form.form(Movie.class)));
    }

    public Result addMovie() {
        Form<Movie> form = Form.form(Movie.class).bindFromRequest();
        Movie movie = form.get();
        Movie savedMovie = repo.addMovie(movie);
        return ok(toJson(savedMovie));
    }

    public Result allMovies() {
        List<Movie> movies = repo.getAllMovies();
        return movies.isEmpty() ? notFound("No movies available")
                : ok(toJson(movies));
    }

    public Result moviesWithTitle(String title) {
        List<Movie> movies = repo.getMoviesWithTitle(title);
        return movies.isEmpty() ? notFound(String.format("No movies found with title '%s'", title))
                : ok(toJson(movies));
    }
}
