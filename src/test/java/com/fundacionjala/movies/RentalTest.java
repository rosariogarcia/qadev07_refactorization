package com.fundacionjala.movies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RentalTest {
    private Rental rental;

    @Test
    public void rentalMustBeContainsTheMovieAndDaysToRent() {
        rental = new Rental(new MovieChildren("The Jungle Book"), 1);
        assertNotNull(rental);
    }

    @Test
    public void theMovieShouldBeEqualsToCreated(){
        rental = new Rental(new MovieChildren("The Jungle Book"), 1);
        assertEquals("The Jungle Book",rental.getMovie().getTitle());
    }
}
