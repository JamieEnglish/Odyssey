package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import com.google.common.base.Objects;

import java.util.HashMap;
import java.util.Map;

public class Movie {
	
	public long counter = 0l;
	public long MovieID;
	public String title;
	public String releaseDate;
	public String URL;
	public int[] genre = new int[19];
	
	
	public Movie(String title, String releaseDate, String URL, int[] genre){
		this.MovieID = counter++;
		this.title = title;
		this.releaseDate = releaseDate;
		this.URL = URL;
		this.genre = genre;
}

	@Override
	public String toString(){
	   return toStringHelper(this).addValue(MovieID)
			   					   .addValue(title)
			   					   .addValue(releaseDate)
			   					   .addValue(URL)
			   					   .addValue(genre)
			   					   .toString();
	}
	
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.MovieID, this.title, this.releaseDate, this.URL, this.genre);  
	  }
	
	@Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof Movie)
	    {
	      final Movie other = (Movie) obj;
	      return Objects.equal(MovieID, other.MovieID) 
	          && Objects.equal(title,  other.title)
	          && Objects.equal(releaseDate,     other.releaseDate)
	          && Objects.equal(URL,  other.URL)
	          && Objects.equal(genre, other.genre);
	    }
	    else
	    {
	      return false;
	    }
	  }
}