package com.fundacionjala.movies;

/**
 * Class for calculate the charge and point of movie
 */
public abstract class Movie {

    protected static final int POINTS = 1;
    protected final String title;
    protected final double priceRent;
    protected final double priceDelay;
    protected final int daysAllowed;

    /**
     * Constructor of class
     *
     * @param title       Movie's title.
     * @param priceRent   Movie's price of rent.
     * @param daysAllowed Days allowed for rent without increment charge.
     * @param priceDelay  Price incremented when days allowed is get over.
     */
    public Movie(String title, double priceRent, int daysAllowed, double priceDelay) {
        this.title = title;
        this.priceRent = priceRent;
        this.priceDelay = priceDelay;
        this.daysAllowed = daysAllowed;
    }

    /**
     * Calculate the Charge of Movie by days rented
     *
     * @param daysRented Days asked to rent a movie by Customer
     * @return Charge of movie by days rented.
     */
    public double calculateChargeMovie(int daysRented) {
        return daysRented > daysAllowed ? priceRent + ((daysRented - daysAllowed) * priceDelay) : priceRent;
    }

    /**
     * Calculate the Points of Movie by days rented
     *
     * @param daysRented Days asked to rent a movie by Customer
     * @return Points of movie by days rented.
     */
    protected int calculatePoints(int daysRented) {
        return POINTS;
    }

    /**
     * Get the title of Movie
     *
     * @return Movie's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the price of Movie
     *
     * @return Movie's price of rent
     */
    public double getPriceRent() {
        return priceRent;
    }

    /**
     * Get the Movie's price delay
     *
     * @return Movie's Price incremented when days allowed is get over.
     */
    public double getPriceDelay() {
        return priceDelay;
    }

    /**
     * Get the Days allowed to rent a movie without charge extra
     *
     * @return Movie's days allowed for rent without increment charge.
     */
    public int getDaysAllowed() {
        return daysAllowed;
    }
}
