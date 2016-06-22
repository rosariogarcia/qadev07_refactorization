package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link Rental}
 */
public class RentalTest {

    public static final String TITLE = "The Jungle Book";
    public static final int DAYS_RENTED = 1;
    private static Movie MOVIE;
    private Rental rental;

    @Before
    public void setUp() {
        MOVIE = new MovieChildren(TITLE);
        rental = new Rental(MOVIE, DAYS_RENTED);
    }

    @Test
    public void testRentalTheInstanceShouldNotBeNull() {
        assertNotNull(rental);
    }

    @Test
    public void testRentalCalculateFrequentPointsForMovie() {
        int expectedPoints = 1;
        assertEquals(expectedPoints, rental.calculateFrequentRenterPoints());
    }

    @Test
    public void testRentalCalculateChargeMovieTest() {
        double chargeByDaysAllowed = MOVIE.getPriceRent();
        assertEquals(chargeByDaysAllowed, rental.calculateCharge(), 0);
    }
}
