package models;

import java.util.HashMap;
import java.util.Map;

public class Movie {
	
	
	public long MovieID;
	public String title;
	public String releaseDate;
	public String URL;
	
	public Map<Long, Rating> ratings = new HashMap<>();

}

public Movie(){
	
}
}
