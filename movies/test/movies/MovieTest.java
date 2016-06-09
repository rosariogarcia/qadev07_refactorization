package movies;

import static org.junit.Assert.*;
import org.junit.Test;

public class MovieTest {

	@Test
	public void theMovieCanBeCreateWithTitleAndPricecode() {
		assertNotNull(new Movie("The Jungle Book",1));
	}
	
	@Test
	public void movieCanBeCreatedWithWithTitleAndPricecodeParameters(){
		Movie newMovie = new Movie("The Jungle Book",1);
		assertTrue(newMovie  instanceof Movie);
	}
	
	@Test
	public void movieTitleMustBeString(){
		Movie newMovie = new Movie("The Jungle Book",1);
		assertTrue(newMovie.getTitle().equals("The Jungle Book"));
	}
	
	@Test
	public void moviePriceCodeMustBeInteger(){
		Movie newMovie = new Movie("The Jungle Book",1);
		assertTrue(newMovie.getPriceCode() == 1);
	}
	
	@Test
	public void movieTitleDoesNotBeInt(){
		Movie newMovie = new Movie("The Jungle Book",1);
		assertFalse(newMovie.getTitle().equals(1));
	}
	
	@Test
	public void moviePriceCodeCanBeSet(){
		Movie newMovie = new Movie("The Jungle Book",1);
		newMovie.setPriceCode(2);
		assertEquals(2,newMovie.getPriceCode());
	}
	
	@Test
	public void movieTitleCanBeGet(){
		Movie newMovie = new Movie("The Jungle Book",1);
		assertEquals("The Jungle Book",newMovie.getTitle());
	}
	
	@Test
	public void movieCodePriceCanBeGet(){
		Movie newMovie = new Movie("The Jungle Book",1);
		assertEquals(1,newMovie.getPriceCode());
	}


}
