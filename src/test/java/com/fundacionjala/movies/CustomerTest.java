package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link Customer}
 */
public class CustomerTest {

    private static final int EXPECTED_SIZE_RENTAL_ONE_MOVIE = 1;
    private Customer customer;
    private Movie movie;

    @Before
    public void setUp() {
        customer = new Customer("Customer Test");
    }

    @Test
    public void testCustomerInstanceShouldNotBeNull() {
        assertNotNull(customer);
    }

    @Test
    public void testCustomerCanBeRentAChildrenMovie() {
        movie = new MovieChildren("The Revenant");
        final int daysRented = 4;
        customer.addRental(new Rental(movie, daysRented));
        assertEquals(EXPECTED_SIZE_RENTAL_ONE_MOVIE, customer.getRentals().size());
    }

    @Test
    public void testCustomerCanBeRentARegularMovie() {
        movie = new MovieRegular("The Jungle Book");
        final int daysRented = 1;
        customer.addRental(new Rental(movie, daysRented));
        assertEquals(EXPECTED_SIZE_RENTAL_ONE_MOVIE, customer.getRentals().size());
    }

    @Test
    public void testCustomerCanBeRentANewReleaseMovie() {
        movie = new MovieNewRelease("X-Men Apocalypses");
        final int daysRented = 1;
        customer.addRental(new Rental(movie, daysRented));
        assertEquals(EXPECTED_SIZE_RENTAL_ONE_MOVIE, customer.getRentals().size());
    }

    @Test
    public void testCustomerCalculateTotalChargeOfMoviesRented() {
        double expectedTotalCharge = 0;
        movie = new MovieNewRelease("X-Men Apocalypses");
        int daysRentedNewRelease = movie.daysAllowed;
        customer.addRental(new Rental(movie, daysRentedNewRelease));
        expectedTotalCharge = expectedTotalCharge + movie.calculateChargeMovie(daysRentedNewRelease);

        movie = new MovieChildren("The Revenant");
        int daysRentedChildren = movie.daysAllowed;
        customer.addRental(new Rental(movie, daysRentedChildren));
        expectedTotalCharge += movie.calculateChargeMovie(daysRentedChildren);

        movie = new MovieRegular("The Jungle Book");
        int daysRentedRegular = movie.daysAllowed;
        customer.addRental(new Rental(movie, daysRentedRegular));
        expectedTotalCharge += movie.calculateChargeMovie(daysRentedRegular);

        assertEquals(expectedTotalCharge, customer.calculateTotalCharge(), Constants.DELTA);
    }

    @Test
    public void testCustomerCalculateTotalFrequentRentedPoints() {

        movie = new MovieNewRelease("X-Men Apocalypses");
        int daysRentedNewRelease = movie.daysAllowed;
        customer.addRental(new Rental(movie, daysRentedNewRelease));
        double expectedTotalFrequentPoints = movie.calculatePoints(daysRentedNewRelease);

        movie = new MovieChildren("The Revenant");
        int daysRentedChildren = movie.daysAllowed;
        customer.addRental(new Rental(movie, daysRentedChildren));
        expectedTotalFrequentPoints += movie.calculatePoints(daysRentedChildren);

        movie = new MovieRegular("The Jungle Book");
        int daysRentedRegular = movie.daysAllowed;
        customer.addRental(new Rental(movie, daysRentedRegular));
        expectedTotalFrequentPoints += movie.calculatePoints(daysRentedRegular);

        assertEquals(expectedTotalFrequentPoints, customer.calculateTotalFrequentRenterPoints(), Constants.DELTA);
    }

    @Test
    public void testCustomerPrintDetailsStatement() {
        movie = new MovieNewRelease("X-Men Apocalypses");
        int daysRentedNewRelease = movie.daysAllowed;
        customer.addRental(new Rental(movie, daysRentedNewRelease));
        System.out.println(customer.statement());
        assertEquals("Rental Record for Customer Test\n" +
                "\tX-Men Apocalypses\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }
}
