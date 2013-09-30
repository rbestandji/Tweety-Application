package controllers;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import models.Tweet;

import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	//méthode static pour le comportement à mettre tt le temps
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
  //  public static Result listTweet() {
  //      return redirect(routes.Application.index());
  //  }
    public static Result listTweet() {
		List<Tweet> tweets =new ArrayList<Tweet>() ;
    	Tweet tweet1 = new Tweet();
    	tweet1.commentaire = "bla bla blza";
    	tweet1.username = "toto";
    	tweet1.creationDate = new Date();
    	tweets.add(tweet1);

    	Tweet tweet2 = new Tweet();
    	tweet2.commentaire = "re bla bla blza";
    	tweet2.username = "lulu";
    	tweet2.creationDate = new Date();
    	tweets.add(tweet2);
    	if (request().accepts("text/html")) return ok(views.html.wall.render(tweets));
    	else if(request().accepts("application/json")) return ok(Json.toJson(tweets));
    	return badRequest();

	//	return ok(views.html.wall.render(tweets));
    }
    
    

}
