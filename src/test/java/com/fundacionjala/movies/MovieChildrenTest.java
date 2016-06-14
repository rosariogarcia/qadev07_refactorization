package com.fundacionjala.movies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MovieChildrenTest {

    @Test
    public void theMovieCanBeCreateWithTitleAndPriceCode() {
        Movie movie = new MovieChildren("The Jungle Book");
        assertNotNull(movie);
    }

    @Test
    public void movieCanBeCreatedWithWithTitleAndPriceCodeParameters() {
        Movie newMovie = new Movie("The Jungle Book", 1);
        assertTrue(newMovie instanceof Movie);
    }

    @Test
    public void movieTitleMustBeString() {
        Movie newMovie = new Movie("The Jungle Book", 1);
        assertTrue(newMovie.getTitle().equals("The Jungle Book"));
    }

    @Test
    public void moviePriceCodeMustBeInteger() {
        Movie newMovie = new Movie("The Jungle Book", 1);
        assertTrue(newMovie.getPriceCode() == 1);
    }

    @Test
    public void movieTitleDoesNotBeInt() {
        Movie newMovie = new Movie("The Jungle Book", 1);
        assertFalse(newMovie.getTitle().equals(1));
    }

    @Test
    public void moviePriceCodeCanBeSet() {
        Movie newMovie = new Movie("The Jungle Book", 1);
        newMovie.setPriceCode(2);
        assertEquals(2, newMovie.getPriceCode());
    }

    @Test
    public void movieTitleCanBeGet() {
        Movie newMovie = new Movie("The Jungle Book", 1);
        assertEquals("The Jungle Book", newMovie.getTitle());
    }

    @Test
    public void movieCodePriceCanBeGet() {
        Movie newMovie = new Movie("The Jungle Book", 1);
        assertEquals(1, newMovie.getPriceCode());
    }
}
