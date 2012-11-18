package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;

import views.html.*;
//import views.html.projects.*;

/**
 * Manage projects related operations.
 */
//@Security.Authenticated(Secured.class)
public class Projects extends Controller {
	
	  /**
     * Zoznam prav podla pozicie vo firme
     */
  /*  public static List<Zoznam> getButtonList (String pozicia){
    //	ArrayList<String> list = new ArrayList<>();
    	ArrayList<Zoznam> list = new ArrayList<>();
    	list.add(new Zoznam("Sklad", "DOPLNIT"));
    	list.add(new Zoznam("Vydat tovar", "DOPLNIT"));
    	list.add(new Zoznam("Prijat tovar", "DOPLNIT"));
    	if(pozicia.equals("skladnik")){
    		return list;    		
    	}else { list.add(new Zoznam("Objednavky", "DOPLNIT"));}
    	return list;    	
    }*/
    
  
    /**
     * Display the dashboard.
     */
	
    public static Result index(String meno,String pozicia) {
      //  return ok(pozadie.render(meno,pozicia)
    	//return ok(hlavna.render(meno,pozicia,getButtonList (pozicia))
    	return ok(uvodnyVyber.render(meno,pozicia)
        );
    }

    public static Result priat(String meno,String pozicia) {
      	return ok(priatTovar.render(meno,pozicia)
          );
      }
    
    public static Result vydat(String meno,String pozicia) {
      	return ok(vydanieTovar.render(meno,pozicia)
          );
      }
    public static Result sklad(String meno,String pozicia) {
      	return ok(sklad.render(meno,pozicia)
          );
      }
    public static Result objednavka(String meno,String pozicia) {
      	return ok(objednavka.render(meno,pozicia)
          );
      }
   

  
}

