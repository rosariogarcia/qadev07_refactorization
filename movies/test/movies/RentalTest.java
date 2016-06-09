package movies;

import static org.junit.Assert.*;

import org.junit.Test;

public class RentalTest {

	@Test
	public void rentalMustBeContainsTheMovieAndDaysToRent() {
		assertNotNull(new Rental(new Movie("The Jungle Book", 1),1));
	}
	
	@Test
	public void rentalMustBeCreatedWithTheMovieAndDaysToRentLikeParameters() {
		Rental newRental = new Rental(new Movie("The Jungle Book", 1),0);
		assertTrue(newRental instanceof Rental);
	}
	
	@Test
	public void daysToRentShouldBeMajorOrEqualThanOne(){
		Rental newRental = new Rental(new Movie("The Jungle Book", 1),1);
		assertTrue(newRental.getDaysRented() >= 1);
	}
	
	@Test
	public void daysToRentShouldNotBeMenorThanOne(){
		Rental newRental = new Rental(new Movie("The Jungle Book", 1),1);
		assertFalse(newRental.getDaysRented() < 1);
	}

}
