package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Charito on 6/13/2016.
 */
public class MovieRegularTest {
    private Movie regularMovie;

    @Before
    public void setUp() {
        regularMovie = new MovieRegular("The Revenant");
    }

    @Test
    public void movieRegularTitleMustBeTheSpecified() {
        assertTrue(regularMovie.getTitle().equals("The Revenant"));
    }

    @Test
    public void theChargeShouldBeCalculateByDaysRented() {
        int daysRented = regularMovie.getDaysAllowed();
        double priceRent = regularMovie.getPriceRent();
        assertEquals(priceRent, regularMovie.calculateChargeMovie(daysRented), 0);
    }

    @Test
    public void theChargeShouldIncrementWhenDaysRentedIsMajorThanDaysAllowed() {
        int daysRented = 2;
        daysRented += regularMovie.getDaysAllowed();
        double priceRent = regularMovie.calculateChargeMovie(daysRented);
        assertTrue(priceRent > regularMovie.daysAllowed);
    }

    @Test
    public void thePointsThatAddShouldBeEqualThanPointsDefined() {
        int daysRented = regularMovie.getDaysAllowed();
        int pointsThatAdd = regularMovie.getPoints();
        assertEquals(pointsThatAdd, regularMovie.calculatePoints(daysRented));
    }
}
