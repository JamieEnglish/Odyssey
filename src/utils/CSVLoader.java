package utils;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.In;
import models.Movie;
import models.User;

public class CSVLoader 
{
	public List<User> loadUsers(String filename) throws Exception 
	{
		File usersFile = new File(filename);
		In inUsers = new In(usersFile);
		String delims = "[|]";
		List<User> users = new ArrayList<User>();
		while (!inUsers.isEmpty()) 
		{
			String userDetails = inUsers.readLine();
			String[] userTokens = userDetails.split(delims);
			if (userTokens.length == 7) 
			{
				String firstName = userTokens[1];
				String lastName = userTokens[2];
				int age = Integer.valueOf(userTokens[3]);
				String gender = userTokens[4];
				String occupation = userTokens[5];
				String zipCode = userTokens[6];
				users.add(new User(firstName, lastName, age, gender, occupation, zipCode));
			} else {
				throw new Exception("Invalid member length: " + userTokens.length);
			}
		}
		return users;
   }
	
	public List<Movie> loadMovies(String filename) throws Exception
	{
		File moviesFile = new File(filename);
		In inMovies = new In(moviesFile);
		String delims = "[|]";
		List<Movie> movies = new ArrayList<>();
		while (!inMovies.isEmpty())
		{
			String movieDetails = inMovies.readLine();
			String[] movieTokens = movieDetails.split(delims);
			if(movieTokens.length == 23)
			{
				String title = movieTokens[1];
				String releaseDate = movieTokens[2];
				String URL = movieTokens[3];
				movies.add(new Movie(title, releaseDate, URL));
			}else {
				throw new Exception("Invalid member length: " + movieTokens.length);
			}
		}
		return movies;
	}
}