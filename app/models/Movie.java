package models;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by enda on 31/08/15.
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue
    public long id;
    @Constraints.Required
    public String title;
    public Date createdDate;
}
