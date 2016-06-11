package com.fundacionjala.movies;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private static final String BREAK_LINE = "\n";

    private static final String TABULATION = "\t";

    private final String name;

    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public double calculateTotalCharge() {
        double totalCharge = 0;
        for (Rental rental : rentals) {
            totalCharge += rental.calculateCharge();
        }
        return totalCharge;
    }

    public int calculateTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public String statement() {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for");
        result.append(getName());
        result.append(BREAK_LINE);
        for(Rental rental : rentals) {
            result.append(TABULATION);
            result.append(rental.getMovie().getTitle());
            result.append(TABULATION);
            result.append(rental.calculateCharge());
            result.append(BREAK_LINE);
        }
        // add footer lines
        result.append("Amount owed is " );
        result.append(calculateTotalCharge());
        result.append(BREAK_LINE);
        result.append("You earned ");
        result.append(calculateTotalFrequentRenterPoints());
        result.append(" frequent renter points");

        return result.toString();
    }

    public String getName() {
        return name;
    }
}
