package com.fundacionjala.movies;

/**
 * Created by Charito on 6/10/2016.
 */
public class MovieNewRelease extends Movie {

    private static final double PRICE_RENT = 3;
    private static final int DAYS_ALLOWED = 1;
    private static final int PRICE_DELAY = 111;

    public MovieNewRelease(String title) {
        super(title, PRICE_RENT, DAYS_ALLOWED, PRICE_DELAY);
    }

    @Override
    public double calculateChargeMovie(int daysRented) {
        return daysRented * getPriceRent();
    }

    @Override
    public int calculatePoints(int daysRented) {
        int newPoints = POINTS;
        if (daysRented > getDaysAllowed()) {
            newPoints++;
        }
        return newPoints;
    }

}
