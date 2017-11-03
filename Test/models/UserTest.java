package models;

import static models.Fixtures.users;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import models.User;

public class UserTest {

	
	User myself = new User("jamie", "english", 22, "M", "Student" , "00010");

	@Test
	public void testCreate()
	{
		assertEquals(1, myself.counter);
		assertEquals("jamie", myself.firstName);
		assertEquals("english", myself.lastName);
		assertEquals(22, myself.age);
		assertEquals("M", myself.gender);
		assertEquals("Student", myself.occupation);
		assertEquals("00010", myself.zipCode);
	}
	
	@Test
	  public void testIds()
	  {
	    Set<Long> ids = new HashSet<>();
	    for (User user : users)
	    {
	      ids.add(user.UserID);
	    }
	    assertEquals (users.length, ids.size());
	  }
	
	@Test
	public void testToString() {
		assertEquals("User{" + myself.UserID + ", jamie, english, 22, M, Student, 00010}"

		, myself.toString());
	}
	
	@Test
	public void testEquals()
	{
		User myself2 = new User("jamie", "english", 22, "M", "Student" , "00010");
		User yourself = new User("Phillip", "Smith", 67, "M", "Carpenter","11101");
		
		assertEquals(myself, myself);
		assertEquals(myself, myself2);
		assertSame(myself, myself);
		assertNotSame(myself, myself2);
		assertNotEquals(myself, yourself);
		
	}
}
