package com.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    private Movie children;
    private Movie regular;
    private Movie newRelease;

    @Before
    public void setUp() {
        customer = new Customer("Customer Test");
    }

    @Test
    public void aCustomerCanBeRentAChildrenMovie() {
        children = new MovieChildren("The Revenant");
        customer.addRental(new Rental(children, 4));
        System.out.println(customer.statement());
        assertEquals(1, customer.getRentals().size());
    }

    @Test
    public void aCustomerCanBeRentARegularMovie() {
        regular = new MovieRegular("The Jungle Book");
        customer.addRental(new Rental(regular, 1));
        System.out.println(customer.statement());
        assertEquals(1, customer.getRentals().size());
    }

    @Test
    public void aCustomerCanBeRentANewReleaseMovie() {
        newRelease = new MovieNewRelease("X-Men Apocalypses");
        customer.addRental(new Rental(newRelease, 1));
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
        newRelease = new MovieNewRelease("X-Men Apocalypses");
        children = new MovieChildren("The Revenant");
        regular = new MovieRegular("The Jungle Book");
        customer.addRental(new Rental(newRelease, 1));
        customer.addRental(new Rental(children, 4));
        customer.addRental(new Rental(regular, 1));
        assertEquals(8, customer.calculateTotalCharge(), 0);
    }

    @Test
    public void canBeCalculateTotalFrequentRentedPoints() {
        newRelease = new MovieNewRelease("X-Men Apocalypses");
        children = new MovieChildren("The Revenant");
        regular = new MovieRegular("The Jungle Book");
        customer.addRental(new Rental(newRelease, 1));
        customer.addRental(new Rental(children, 4));
        customer.addRental(new Rental(regular, 1));
        assertEquals(3, customer.calculateTotalFrequentRenterPoints(), 0);
    }
}
