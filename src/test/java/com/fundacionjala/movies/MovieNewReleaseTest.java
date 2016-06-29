package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link MovieNewRelease}
 */
public class MovieNewReleaseTest {
    private final String title = "X-Men Apocalipsys";
    private Movie newReleaseMovie;
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
        final double expectedPrice = priceRent * daysRented;
        assertEquals(expectedPrice, newReleaseMovie.calculateChargeMovie(daysRented), Constants.DELTA);
    }

    @Test
    public void testMovieNewReleaseCalculatePointsWhenDaysRentedAreMinorOrEqualThanDaysAllowed() {
        final int expectedPoints = newReleaseMovie.POINTS;
        assertEquals(expectedPoints, newReleaseMovie.calculatePoints(daysRented));
    }

    @Test
    public void testMovieNewReleaseCalculatePointsWhenDaysRentedIsMajorThanDaysAllowed() {
        daysRented++;
        final int expectedPoints = newReleaseMovie.POINTS;
        assertEquals(expectedPoints + 1, newReleaseMovie.calculatePoints(daysRented));
    }
}
