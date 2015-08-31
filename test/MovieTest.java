import configs.AppConfig;
import models.Movie;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class MovieTest extends AbstractTransactionalJUnit4SpringContextTests {
 
    @Test
    public void setMovieName() {
        Movie movie = new Movie();
        movie.title = "foo";
        assertThat(movie.title).isEqualTo("foo");
    }

}
