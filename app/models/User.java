package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * User entity managed by Ebean
 */
@Entity 
@Table(name="konta")
public class User extends Model {

    @Id
    @Constraints.Required
    @Formats.NonEmpty
    private String email;
    
    @Constraints.Required
    private String name;
    
    @Constraints.Required
    private String password;
    
    @Constraints.Required
    private String pozicia;
    
    // -- Queries
    
    public static Model.Finder<String,User> find = new Model.Finder(String.class, User.class);
    
    /**
     * Retrieve all users.
     */
    public static List<User> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from email.
     */
    public static User findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
    
    /**
     * Authenticate a User.
     */
    public static User authenticate(String email, String password) {
        return find.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
    }
    
    // --
    
    public String toString() {
        return "User(" + email + ")";
    }
    
    public static String getName(String email) {
        return find.where().eq("email", email).findUnique().name;
    }
    public static String getPozicia(String email) {
        return find.where().eq("email", email).findUnique().pozicia;
    }

}

