package controllers;

import java.util.ArrayList;

import play.*;
import play.mvc.*;
import play.data.*;

import models.*;
import views.html.*;

public class Application extends Controller {
	public String meno;
	public String pozicia;
  
    // -- Authentication
    
    public static class Login {
        
        public String email;
        public String password;
        
        public String validate() {
            if(User.authenticate(email, password) == null) {
                return "Zle meno alebo heslo";
            }
            return null;
        }
        
    }

    /**
     * Login page.
     */
    public static Result login() {
        return ok(
            login.render(form(Login.class))
        );
    }
  
    /**
     * Handle login form submission.
     */
    public static Result authenticate() {

        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
        	
            return badRequest(login.render(loginForm));
        } else {
            session("email", loginForm.get().email);
            String email=loginForm.get().email;
            String meno=User.getName(email);
            String pozicia=User.getPozicia(email);
                return redirect(
                routes.Projects.index(meno,pozicia)
            );
        }
    }
}
