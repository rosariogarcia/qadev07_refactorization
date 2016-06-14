package com.fundacionjala.movies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Charito on 6/13/2016.
 */
public class MovieRegularTest {
    private Movie regularMovie;

    @Test
    public void movieRegularTitleMustBeTheSpecified() {
        regularMovie = new MovieRegular("The Revenant");
        assertTrue(regularMovie.getTitle().equals("The Revenant"));
    }

    @Test
    public void movieRegularPriceRentCanBeSet() {
        regularMovie = new MovieRegular("The Revenant");
        regularMovie.setPriceRent(2);
        assertEquals(2, regularMovie.getPriceRent(),0);
    }

    @Test
    public void theChargeShouldBeCalculateByDaysRented(){
        regularMovie = new MovieRegular("The Revenant");
        int daysRented = regularMovie.getDaysAllowed();
        double priceRent = regularMovie.getPriceRent();
        assertEquals(priceRent, regularMovie.calculateChargeMovie(daysRented),0);
    }

    @Test
    public void theChargeShouldIncrementWhenDaysRentedIsMajorThanDaysAllowed(){
        regularMovie = new MovieRegular("The Revenant");
        int daysRented = 2;
        daysRented += regularMovie.getDaysAllowed();
        double priceRent = regularMovie.calculateChargeMovie(daysRented) ;
        assertTrue(priceRent > regularMovie.daysAllowed);
    }

    @Test
    public void thePointsThatAddShouldBeEqualThanPointsDefined(){
        regularMovie = new MovieRegular("The Revenant");
        int daysRented =  regularMovie.getDaysAllowed();
        int pointsThatAdd = regularMovie.getPoints();
        assertEquals(pointsThatAdd, regularMovie.calculatePoints(daysRented));
    }
}
