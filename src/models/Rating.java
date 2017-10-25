package models;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class Rating {
	  
	  static Long counter = 0l;
	  public Long RatingID;
	  public int ItemID;
	  public int timestamp;
	  
	  public Rating(long RatingID, int ItemID, int timestamp)
	  {
		  this.RatingID = RatingID;
		  this.ItemID = ItemID;
		  this.timestamp = timestamp;
	  }
	  
	  public List<Movie> movie = new ArrayList<Movie>();
	  
	  @Override
	  public int hashCode()
	  {
		  return Objects.hashCode(this.RatingID, this.ItemID, this.timestamp);
	  }
	  
	  @Override
	  public boolean equals(final Object obj)
	  {
		  if (obj instanceof Rating) 
		  {
			  final Rating other = (Rating) obj;
			  return Objects.equal(RatingID, other.RatingID)
					  && Objects.equal(ItemID, other.ItemID)
					  && Objects.equal(timestamp, other.timestamp);
		  }
			  else
			    {
			      return false;
			    }
		 
	  }
}
