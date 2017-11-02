package controllers;

import java.util.Collection;

import com.google.common.base.Optional;

import java.util.HashMap;
import java.util.Map;

import utils.Serializer;
import models.Movie;
import models.Rating;
import models.User;


public class OdysseyAPI 
{	
	private Map<Long, User> userIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex = new HashMap<>();
	private Map<Long, Rating> ratingIndex = new HashMap<>();
	private Serializer serializer;
	
	public OdysseyAPI(Serializer serializer)
	{
		this.serializer = serializer;
	}
	
	@SuppressWarnings("unchecked")
	  public void load() throws Exception
	  {
	    serializer.read();
	    userIndex = (Map<Long, User>) serializer.pop();
	    movieIndex = (Map<Long, Movie>) serializer.pop();
	    ratingIndex = (Map<Long, Rating>) serializer.pop();
	  }
	
	void store() throws Exception
	  {
	    serializer.push(userIndex);
	    serializer.push(movieIndex);
	    serializer.push(ratingIndex);
	    serializer.write(); 
	  }
	
	
	public User addUser(String firstName, String lastName, int age, String gender, String occupation, String zipCode)
	{
		User user = new User (firstName, lastName, age, gender, occupation, zipCode);
		userIndex.put(user.UserID, user);
		return user;
	}
	
	public User getUser(long UserID)
	{
		return userIndex.get(UserID);
	}
	
	public void removeUser(long UserID)
	{
		userIndex.remove(UserID);
	}
	
	
	public Movie addMovie(String title, String releaseDate, String URL, int[] genre)
	{
		Movie movie = new Movie(title, releaseDate, URL, genre);
		movieIndex.put(movie.MovieID, movie);
		return movie;
	}
	
	public Movie getMovie(Long MovieID)
	{
		return movieIndex.get(MovieID);
	}
	
	public void removeMovie(Long MovieID)
	{
		movieIndex.remove(MovieID);
	}
	
	public Rating addRating(Long UserID, Long ItemID, int rating, int timestamp)
	  {
		  Rating thisRating = null;
		    Optional<User> user = Optional.fromNullable(userIndex.get(UserID));
		    if (user.isPresent())
		    {
		      thisRating = new Rating(UserID, ItemID, rating, timestamp);
		      user.get().ratings.put(thisRating.UserID, thisRating);
		      ratingIndex.put(thisRating.UserID, thisRating);
		    }
		    return thisRating;
	  }
	
	public Rating getRating(Long UserID)
	{
		return ratingIndex.get(UserID);
		
	}
}
