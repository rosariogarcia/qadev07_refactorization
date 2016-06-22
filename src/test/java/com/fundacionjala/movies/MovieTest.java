package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link Movie}
 */
public class MovieTest {
    public static final String TITLE = "La vita é bella";
    private Movie movie;
    private int daysRented;

    @Before
    public void setUp() {
        movie = new MovieRegular(TITLE);
        daysRented = movie.getDaysAllowed();
    }

    @Test
    public void testMovieInstanceShouldNotBeNull() {
        assertNotNull(movie);
    }

    @Test
    public void testMovieCalculateChargeWhenDaysRentedIsMinorOrEqualToDaysAllowed() {

        double priceRent = movie.getPriceRent();
        assertEquals(priceRent, movie.calculateChargeMovie(daysRented), Constants.DELTA);
    }

    @Test
    public void testMovieChargeIncrementWhenDaysRentedIsMajorThanDaysAllowed() {
        daysRented++;
        double expectedPrice = movie.priceRent + ((daysRented - movie.daysAllowed) * movie.priceDelay);
        assertEquals(expectedPrice, movie.calculateChargeMovie(daysRented), Constants.DELTA);
    }

    @Test
    public void testMovieCalculatePoints() {
        int pointsThatAdd = movie.POINTS;
        assertEquals(pointsThatAdd, movie.calculatePoints(daysRented));
    }
}
