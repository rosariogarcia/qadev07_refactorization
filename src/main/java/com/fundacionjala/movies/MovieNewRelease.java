package com.fundacionjala.movies;

/**
 * @author RosarioGarcia
 *         {@inheritDoc}
 */
public class MovieNewRelease extends Movie {

    private static final double PRICE_RENT = 3;
    private static final int DAYS_ALLOWED = 1;
    private static final int PRICE_DELAY = 0;

    /**
     * Constructor class that recive the Movie's title
     *
     * @param title Movie's title
     */
    public MovieNewRelease(String title) {
        super(title, PRICE_RENT, DAYS_ALLOWED, PRICE_DELAY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculateChargeMovie(int daysRented) {
        return daysRented * priceRent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculatePoints(int daysRented) {
        return daysRented > daysAllowed ? POINTS + 1 : POINTS;
    }

}
