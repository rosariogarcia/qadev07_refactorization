package com.fundacionjala.movies;

class Rental {
    private final Movie movie;

    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double calculateCharge() {
        return movie.calculateChargeMovie(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return movie.calculatePoints(daysRented);
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}