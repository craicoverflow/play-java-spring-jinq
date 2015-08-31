package repositories;

import configs.JinqSource;
import models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by enda on 31/08/15.
 */
@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {

    @PersistenceContext
    EntityManager em;

    @Autowired
    JinqSource source;

    @Override
    public Movie addMovie(Movie movie) {
        em.persist(movie);
        return movie;
    }

    @Override
    public List<Movie> getMoviesWithTitle(String title) {
        return source.movies(em)
                .where(m -> m.title.toLowerCase()
                        .equals(title.toLowerCase()))
                .toList();
    }

    @Override
    public List<Movie> getAllMovies() {
        return source.movies(em).toList();
    }
}
