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
     * @param daysRented Days asked to rent a movie by Customer
     * @return Charge of movie by days rented.
     */
    public double calculateChargeMovie(int daysRented) {
        return daysRented > daysAllowed ? priceRent + ((daysRented - daysAllowed) * priceDelay) : priceRent;
    }

    /**
     * @param daysRented Days asked to rent a movie by Customer
     * @return Points of movie by days rented.
     */
    protected int calculatePoints(int daysRented) {
        return POINTS;
    }

    /**
     * @return Movie's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Movie's price of rent
     */
    public double getPriceRent() {
        return priceRent;
    }

    /**
     * @return Movie's Price incremented when days allowed is get over.
     */
    public double getPriceDelay() {
        return priceDelay;
    }

    /**
     * @return Movie's days allowed for rent without increment charge.
     */
    public int getDaysAllowed() {
        return daysAllowed;
    }
}
