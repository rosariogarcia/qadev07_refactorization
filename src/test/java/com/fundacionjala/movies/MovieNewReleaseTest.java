package com.fundacionjala.movies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Charito on 6/13/2016.
 */
public class MovieNewReleaseTest {
    private Movie newReleaseMovie;

    @Test
    public void movieRegularTitleMustBeTheSpecified() {
        newReleaseMovie = new MovieNewRelease("X-Men Apocalipsys");
        assertTrue(newReleaseMovie.getTitle().equals("X-Men Apocalipsys"));
    }

    @Test
    public void movieRegularPriceRentCanBeSet() {
        newReleaseMovie = new MovieNewRelease("X-Men Apocalipsys");
        newReleaseMovie.setPriceRent(2);
        assertEquals(2, newReleaseMovie.getPriceRent(),0);
    }

    @Test
    public void theChargeShouldBeCalculateByDaysRented(){
        newReleaseMovie = new MovieNewRelease("X-Men Apocalipsys");
        int daysRented = newReleaseMovie.getDaysAllowed();
        double priceRent = newReleaseMovie.getPriceRent();
        assertEquals(priceRent, newReleaseMovie.calculateChargeMovie(daysRented),0);
    }

    @Test
    public void theChargeShouldIncrementWhenDaysRentedIsMajorThanDaysAllowed(){
        newReleaseMovie = new MovieNewRelease("X-Men Apocalipsys");
        int daysRented = 2;
        daysRented += newReleaseMovie.getDaysAllowed();
        double priceRent = newReleaseMovie.calculateChargeMovie(daysRented) ;
        assertTrue(priceRent > newReleaseMovie.daysAllowed);
    }

    @Test
    public void thePointsThatAddShouldBeEqualThanPointsDefinedWhenDaysRentedAreEqualThanDaysAllowed(){
        newReleaseMovie = new MovieNewRelease("X-Men Apocalipsys");
        int daysRented =  newReleaseMovie.getDaysAllowed();
        int pointsThatAdd = newReleaseMovie.getPoints();
        assertEquals(pointsThatAdd, newReleaseMovie.calculatePoints(daysRented));
    }

    @Test
    public void thePointsThatAddShouldIncrementInPointsDefinedWhenDaysRentedAreMajorThanDaysAllowed(){
        newReleaseMovie = new MovieNewRelease("X-Men Apocalipsys");
        int daysRented =  newReleaseMovie.getDaysAllowed();
        int pointsThatAdd = newReleaseMovie.getPoints();
        assertEquals(pointsThatAdd+pointsThatAdd, newReleaseMovie.calculatePoints(++daysRented));
    }
}