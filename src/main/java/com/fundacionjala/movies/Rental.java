package com.fundacionjala.movies;

/**
 * This class contains the rents of Movies
 */
class Rental {
    private final Movie movie;

    private final int daysRented;

    /**
     * Constructor class
     *
     * @param movie      Movie
     * @param daysRented Days asked of rent a movie by Customer
     */
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    /**
     * Calculate charge by movie
     *
     * @return charge
     */
    public double calculateCharge() {
        return movie.calculateChargeMovie(daysRented);
    }

    /**
     * Calculate points by movie
     *
     * @return points
     */
    public int calculateFrequentRenterPoints() {
        return movie.calculatePoints(daysRented);
    }

    /**
     * @return Movie
     */
    public Movie getMovie() {
        return movie;
    }
}