package com.fundacionjala.movies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieChildrenTest {

    private Movie newMovie;

    @Test
    public void movieChildrenTitleMustBeTheSpecified() {
        newMovie = new MovieChildren("The Jungle Book");
        assertTrue(newMovie.getTitle().equals("The Jungle Book"));
    }

    @Test
    public void movieChildrenPriceRentCanBeSet() {
        newMovie = new MovieChildren("The Jungle Book");
        newMovie.setPriceRent(2);
        assertEquals(2, newMovie.getPriceRent(),0);
    }

    @Test
    public void theChargeShouldBeCalculateByDaysRented(){
        newMovie = new MovieChildren("The Jungle Book");
        int daysRented = newMovie.getDaysAllowed();
        double priceRent = newMovie.getPriceRent();
        assertEquals(priceRent, newMovie.calculateChargeMovie(daysRented),0);
    }

    @Test
    public void theChargeShouldIncrementWhenDaysRentedIsMajorThanDaysAllowed(){
        newMovie = new MovieChildren("The Jungle Book");
        int daysRented = 2;
        daysRented += newMovie.getDaysAllowed();
        double priceRent = newMovie.calculateChargeMovie(daysRented) ;
        assertEquals(priceRent, newMovie.calculateChargeMovie(daysRented),0);
    }

    @Test
    public void thePointsThatAddShouldBeEqualThanPointsDefined(){
        newMovie = new MovieChildren("The Jungle Book");
        int daysRented =  newMovie.getDaysAllowed();
        int pointsThatAdd = newMovie.getPoints();
        assertEquals(pointsThatAdd,newMovie.calculatePoints(daysRented));
    }
}
