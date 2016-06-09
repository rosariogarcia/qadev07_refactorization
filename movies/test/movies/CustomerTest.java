package movies;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void customerCanBeCreated() {
		assertNotNull(new Customer("Customer Test"));
	}
	
	@Test
	public void customerCanBeCreatedWithNameParameter(){
		Customer newCustomer = new Customer("Customer Test");
		assertTrue(newCustomer instanceof Customer);
	}
	
	@Test
	public void customerNameShouldBeSameThanTheObjectCreated(){
		Customer newCustomer = new Customer("Customer Test");
		assertEquals("Customer Test", newCustomer.getName());
	}
	
	@Test
	public void movieNewReleaseAmmountShouldBeThreeWhenTheDaysToRentAreMenorOrEqualThanTwo(){
		Customer newCustomer = new Customer("Customer Test");
		Movie newMovie = new Movie("The Jungle Book", 1);
		Rental newRental = new Rental(newMovie, 2);
		double ammount = newCustomer.selectMovie(0, newRental)/2;
		assertEquals(3, ammount, 0);
	}
	
	@Test
	public void movieReleaseAmmountShouldBeTwoWhenTheDaysToRentAreMenorOrEqualThanTwo(){
		Customer newCustomer = new Customer("Customer Test");
		Movie newMovie = new Movie("The Jungle Book", 2);
		Rental newRental = new Rental(newMovie, 2);
		double ammount = newCustomer.selectMovie(0, newRental);
		assertEquals(1.5, ammount, 0);
	}

}
