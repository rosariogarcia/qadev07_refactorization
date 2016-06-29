package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link Rental}
 */
public class RentalTest {

    private static final String TITLE = "The Jungle Book";
    private static final int DAYS_RENTED = 1;
    private Movie movie;
    private Rental rental;

    @Before
    public void setUp() {
        movie = new MovieChildren(TITLE);
        rental = new Rental(movie, DAYS_RENTED);
    }

    @Test
    public void testRentalTheInstanceShouldNotBeNull() {
        assertNotNull(rental);
    }

    @Test
    public void testRentalCalculateFrequentPointsForMovie() {
        final int expectedPoints = 1;
        assertEquals(expectedPoints, rental.calculateFrequentRenterPoints());
    }

    @Test
    public void testRentalCalculateChargeMovieTest() {
        final double chargeByDaysAllowed = movie.getPriceRent();
        assertEquals(chargeByDaysAllowed, rental.calculateCharge(), 0);
    }
}
