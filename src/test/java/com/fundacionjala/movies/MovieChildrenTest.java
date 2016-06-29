package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link MovieChildren}
 */
public class MovieChildrenTest {
    private final String title = "Angry Birds";
    private Movie movieChildren;
    private int daysRented;
    private double priceRent;
    private double priceDelay;

    @Before
    public void SetUP() {
        movieChildren = new MovieChildren(title);
        daysRented = movieChildren.getDaysAllowed();
        priceRent = movieChildren.getPriceRent();
        priceDelay = movieChildren.getPriceDelay();
    }

    @Test
    public void testMovieChildrenInstanceShouldNotBeNull() {
        assertNotNull(movieChildren);
    }

    @Test
    public void testMovieChildrenCalculateChargeByDaysRented() {
        final double priceRent = movieChildren.getPriceRent();
        assertEquals(priceRent, movieChildren.calculateChargeMovie(daysRented), Constants.DELTA);
    }

    @Test
    public void testMovieChildrenChargeIncrementWhenDaysRentedIsMajorThanDaysAllowed() {
        daysRented++;
        final double expectedPrice = priceRent + ((daysRented - movieChildren.daysAllowed) * priceDelay);
        assertEquals(expectedPrice, movieChildren.calculateChargeMovie(daysRented), Constants.DELTA);
    }

    @Test
    public void testMovieChildrenPointsShouldBeOne() {
        final int expectedPoints = movieChildren.POINTS;
        assertEquals(expectedPoints, movieChildren.calculatePoints(daysRented));
    }
}
