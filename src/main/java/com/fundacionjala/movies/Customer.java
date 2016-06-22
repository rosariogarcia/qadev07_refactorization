package com.fundacionjala.movies;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to define methods that can do a Customer
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
     * @return total charge of movies rented
     */
    public double calculateTotalCharge() {
        double totalCharge = 0;
        for (Rental rental : rentals) {
            totalCharge += rental.calculateCharge();
        }
        return totalCharge;
    }

    /**
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
     * @return list of rents
     */
    public List<Rental> getRentals() {
        return rentals;
    }
}
