package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest 
{
	Movie testMovie = new Movie("Interstellar (2014)", "01-Jan-2014", "http://www.imdb.com/title/tt0816692/?ref_=nv_sr_2");

	@Test
	public void testCreate()
	{
		assertEquals("Interstellar (2014)", testMovie.title);
		assertEquals("01-Jan-2014", testMovie.releaseDate);
		assertEquals("http://www.imdb.com/title/tt0816692/?ref_=nv_sr_2", testMovie.URL);
	}
	
	@Test
	public void testToString()
	{
		
	}
	
	@Test
	public void testEquals()
	{
		
	}

}
