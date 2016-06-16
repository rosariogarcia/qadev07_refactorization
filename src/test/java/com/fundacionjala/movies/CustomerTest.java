package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    private Movie movie;

    @Before
    public void setUp() {
        customer = new Customer("Customer Test");
    }

    @Test
    public void aCustomerCanBeRentAChildrenMovie() {
        movie = new MovieChildren("The Revenant");
        customer.addRental(new Rental(movie, 4));
        System.out.println(customer.statement());
        assertEquals(1, customer.getRentals().size());
    }

    @Test
    public void aCustomerCanBeRentARegularMovie() {
        movie = new MovieRegular("The Jungle Book");
        customer.addRental(new Rental(movie, 1));
        System.out.println(customer.statement());
        assertEquals(1, customer.getRentals().size());
    }

    @Test
    public void aCustomerCanBeRentANewReleaseMovie() {
        movie = new MovieNewRelease("X-Men Apocalypses");
        customer.addRental(new Rental(movie, 1));
        System.out.println(customer.statement());
        assertEquals(1, customer.getRentals().size());
    }

    @Test
    public void customerNameShouldBeSameThanTheObjectCreated() {
        customer = new Customer("Customer Test");
        assertEquals("Customer Test", customer.getName());
    }

    @Test
    public void canBeCalculateTotalChargeOfMoviesRented() {
        movie = new MovieNewRelease("X-Men Apocalypses");
        movie = new MovieChildren("The Revenant");
        movie = new MovieRegular("The Jungle Book");
        customer.addRental(new Rental(movie, 1));
        customer.addRental(new Rental(movie, 4));
        customer.addRental(new Rental(movie, 1));
        assertEquals(9, customer.calculateTotalCharge(), 0);
    }

    @Test
    public void canBeCalculateTotalFrequentRentedPoints() {
        movie = new MovieNewRelease("X-Men Apocalypses");
        movie = new MovieChildren("The Revenant");
        movie = new MovieRegular("The Jungle Book");
        customer.addRental(new Rental(movie, 1));
        customer.addRental(new Rental(movie, 4));
        customer.addRental(new Rental(movie, 1));
        assertEquals(3, customer.calculateTotalFrequentRenterPoints(), 0);
    }
}
