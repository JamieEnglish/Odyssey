package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.*;

import com.google.common.base.Objects;

public class User {
	
	public static long counter = 0l;
	public long UserID;
	public String firstName;
	public String lastName;
	public int age;
	public String gender;
	public String occupation;
	public String zipCode;
	
	public Map<Long, Rating> ratings = new HashMap<>();
	
	public User(String firstName, String lastName, int age, String gender, String occupation, String zipCode)
	  {
		this.UserID = counter++;
		this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	    this.gender = gender;
	    this.occupation = occupation;
	    this.zipCode = zipCode;
	  }
	
	@Override
	  public String toString()
	  {
		   return toStringHelper(this).addValue(UserID)
				   					   .addValue(firstName)
				   					   .addValue(lastName)
				   					   .addValue(age)
				   					   .addValue(gender)
				   					   .addValue(occupation)
				   					   .addValue(zipCode)
				   					   .toString();
	  }
	
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.firstName, this.lastName, this.age, this.gender, this.occupation, this.zipCode);  
	  }
	
	@Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof User)
	    {
	      final User other = (User) obj;
	      return Objects.equal(firstName, other.firstName) 
	          && Objects.equal(lastName,  other.lastName)
	          && Objects.equal(age,     other.age)
	          && Objects.equal(gender,  other.gender)
	          && Objects.equal(occupation, other.occupation)
	          && Objects.equal(zipCode, other.zipCode);
	    }
	    else
	    {
	      return false;
	    }
	  }
}
