package de.htwg.seapal.waypoint.controllers;

import com.google.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;
import de.htwg.seapal.waypoint.views.html.*;

public class PlayWaypointController extends Controller {
	
	@Inject
	private IWaypointController waypointController;
	
    public static Result index() {
        return ok(index.render("Index Page of Waypoint Demo"));
    }
  
    public Result test() {
    	String msg;
    	if (waypointController != null) {
    		msg = "WP Controller was injected";
    	} else {
    		msg = "WP Controller was NOT injected";
    	}
    	
        return ok(index.render(msg));
    }
}
