package repositories;

import configs.JinqSource;
import models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

/**
 * Created by enda on 31/08/15.
 */
@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JinqSource source;

    @Override
    public Movie addMovie(Movie movie) {
        movie.createdDate = currentDate();
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

    private Date currentDate() {
        return new Date(System.currentTimeMillis());
    }
}
