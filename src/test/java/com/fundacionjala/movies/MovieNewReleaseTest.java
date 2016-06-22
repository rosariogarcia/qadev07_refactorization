package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link MovieNewRelease}
 */
public class MovieNewReleaseTest {
    private Movie newReleaseMovie;
    private final String title = "X-Men Apocalipsys";
    private int daysRented;
    private double priceRent;

    @Before
    public void SetUP() {
        newReleaseMovie = new MovieNewRelease(title);
        daysRented = newReleaseMovie.getDaysAllowed();
        priceRent = newReleaseMovie.getPriceRent();
    }

    @Test
    public void testMovieNewReleaseInstanceShouldNotBeNull() {
        assertNotNull(newReleaseMovie);
    }

    @Test
    public void testMovieNewReleaseCalculateChargeByDayRented() {
        double expectedPrice = priceRent * daysRented;
        assertEquals(expectedPrice, newReleaseMovie.calculateChargeMovie(daysRented), Constants.DELTA);
    }

    @Test
    public void testMovieNewReleaseCalculatePointsWhenDaysRentedAreMinorOrEqualThanDaysAllowed() {
        int expectedPoints = newReleaseMovie.POINTS;
        assertEquals(expectedPoints, newReleaseMovie.calculatePoints(daysRented));
    }

    @Test
    public void testMovieNewReleaseCalculatePointsWhenDaysRentedIsMajorThanDaysAllowed() {
        daysRented++;
        int expectedPoints = newReleaseMovie.POINTS;
        assertEquals(++expectedPoints, newReleaseMovie.calculatePoints(daysRented));
    }
}
