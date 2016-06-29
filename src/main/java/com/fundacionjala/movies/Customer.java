package com.fundacionjala.movies;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to define methods that can do a Customer like do a new rent of movie,
 * calculate the total charge of movies rented,
 * calculate the total renter points,
 * and display the details of movies rented.
 */
class Customer {
    private static final String BREAK_LINE = "\n";

    private static final String TABULATION = "\t";

    private final String name;

    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    /**
     * Add a new rent of movie
     */
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    /**
     * Calculates the total charges for all rentals
     *
     * @return total charge of rented movies
     */
    public double calculateTotalCharge() {
        double totalCharge = 0;
        for (Rental rental : rentals) {
            totalCharge += rental.calculateCharge();
        }
        return totalCharge;
    }

    /**
     * Calculate the total renter points of movies rented
     *
     * @return total points of movies rented
     */
    public int calculateTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    /**
     * This method display the details of all movies rented,
     * the amount by movie,
     * the total points
     * and the total amount
     *
     * @return Detail of movies rented
     */
    public String statement() {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ");
        result.append(name);
        result.append(BREAK_LINE);
        for (Rental rental : rentals) {
            result.append(TABULATION);
            result.append(rental.getMovie().getTitle());
            result.append(TABULATION);
            result.append(rental.calculateCharge());
            result.append(BREAK_LINE);
        }
        result.append("Amount owed is ");
        result.append(calculateTotalCharge());
        result.append(BREAK_LINE);
        result.append("You earned ");
        result.append(calculateTotalFrequentRenterPoints());
        result.append(" frequent renter points");
        return result.toString();
    }

    /**
     * List the movies rented
     *
     * @return list of rents
     */
    public List<Rental> getRentals() {
        return rentals;
    }
}
