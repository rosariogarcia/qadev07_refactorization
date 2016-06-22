package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link MovieRegular}
 */
public class MovieRegularTest {
    private final String title = "The Revenant";
    private Movie movieRegular;
    private int daysRented;
    private double priceRent;
    private double priceDelay;

    @Before
    public void SetUP() {
        movieRegular = new MovieRegular(title);
        daysRented = movieRegular.getDaysAllowed();
        priceRent = movieRegular.getPriceRent();
        priceDelay = movieRegular.getPriceDelay();
    }

    @Test
    public void testMovieRegularInstanceShouldNotBeNull() {
        assertNotNull(movieRegular);
    }

    @Test
    public void testMovieRegularCalculateChargeByDaysRented() {
        double priceRent = movieRegular.getPriceRent();
        assertEquals(priceRent, movieRegular.calculateChargeMovie(daysRented), Constants.DELTA);
    }

    @Test
    public void testMovieRegularChargeIncrementWhenDaysRentedIsMajorThanDaysAllowed() {
        daysRented++;
        double expectedPrice = priceRent + ((daysRented - movieRegular.daysAllowed) * priceDelay);
        assertEquals(expectedPrice, movieRegular.calculateChargeMovie(daysRented), Constants.DELTA);
    }

    @Test
    public void testMovieRegularPointsShouldBeOne() {
        int expectedPoints = movieRegular.POINTS;
        assertEquals(expectedPoints, movieRegular.calculatePoints(daysRented));
    }
}
