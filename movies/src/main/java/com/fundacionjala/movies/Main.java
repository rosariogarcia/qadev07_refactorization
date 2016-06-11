package com.fundacionjala.movies;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Test");
        Movie children = new MovieChildren("The Revenant", 2);
        Movie regular = new MovieRegular("The Jungle Book", 0);
        Movie newRelease = new MovieNewRelease("X-Men Apocalypses", 1);
        customer.addRental(new Rental(children, 4));
        customer.addRental(new Rental(regular, 1));
        customer.addRental(new Rental(newRelease, 1));
        System.out.println(customer.statement());
    }
}
