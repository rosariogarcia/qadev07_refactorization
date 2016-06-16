package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RentalTest {

    private final String title = "The Jungle Book";
    private Movie movie;
    private Rental rental;

    @Before
    public void setUp() {
        rental = new Rental(new MovieChildren(title), 1);
    }

    @Test
    public void rentalMustBeContainsTheMovieAndDaysToRent() {
        assertNotNull(rental);
    }

    @Test
    public void theMovieShouldBeEqualsToCreated() {
        assertEquals(title, rental.getMovie().getTitle());
    }

    @Test
    public void calculateChargeMovieTest() {
        movie = new MovieChildren(title);
        double chargeByDaysAllowed = movie.getPriceRent();
        assertEquals(chargeByDaysAllowed, rental.calculateCharge(), 0);
    }
}
