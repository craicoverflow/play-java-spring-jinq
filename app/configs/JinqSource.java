package configs;

import models.Movie;
import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by enda on 31/08/15.
 */
@Component
public class JinqSource {
    private JinqJPAStreamProvider streams;

    @PersistenceUnit
    public void setEntityManagerFactory(
            EntityManagerFactory emf) throws Exception {
        streams = new JinqJPAStreamProvider(emf);
    }

    // Wrapper that passes through Jinq requests to Jinq
    public <U> JPAJinqStream<U> streamAll(
            EntityManager em, Class<U>entity) {
        return streams.streamAll(em, entity);
    }

    public JPAJinqStream<Movie> movies(EntityManager em) {
        return streams.streamAll(em, Movie.class);
    }
}
