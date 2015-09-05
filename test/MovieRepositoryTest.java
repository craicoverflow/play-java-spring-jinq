import configs.AppConfig;
import models.Movie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import repositories.MovieRepository;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class MovieRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Inject
    private MovieRepository repo;

    @Test
    public void createMovie() {
        Movie movie = new Movie();
        movie.title = "foo";
        repo.addMovie(movie);
        assertThat(movie.id).isNotNull();
    }

    @Test
    public void getMovies() {
        createMovie();
        List<Movie> movies = repo.getAllMovies();
        assertThat(movies.size()).isEqualTo(1);
    }

}