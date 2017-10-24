package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.*;

import com.google.common.base.Objects;

public class User {
	
	public String firstName;
	public String lastName;
	public int age;
	public String gender;
	public String occupation;
	public long UserID;
	public long counter = 0l;
	
	
	
	public User(String firstName, String lastName, int age, String gender, String occupation)
	  {
	    this.UserID = counter++;
		this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	    this.gender = gender;
	    this.occupation = occupation;
	  }
	
	@Override
	  public String toString()
	  {
		   return 
				   toStringHelper(this).addValue(UserID)
				   					   .addValue(firstName)
				   					   .addValue(age)
				   					   .addValue(gender)
				   					   .addValue(occupation)
				   					   .toString();
	               
	  }
}
