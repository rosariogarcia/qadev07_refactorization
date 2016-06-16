package com.fundacionjala.movies;

/**
 * Created by Charito on 6/10/2016.
 */
public class MovieChildren extends Movie {

    private static final double PRICE_RENT = 1.5;
    private static final int DAYS_ALLOWED = 3;
    private static final double PRICE_DELAY = 1.5;
    private static final int POINTS = 1;

    public MovieChildren(String title) {
        super(title);
        super.priceRent = PRICE_RENT;
        super.daysAllowed = DAYS_ALLOWED;
        super.priceDelay = PRICE_DELAY;
        super.points = POINTS;
    }

    @Override
    public double calculateChargeMovie(int daysRented) {
        double charge = priceRent;
        if (daysRented > daysAllowed) {
            charge += (daysRented - daysAllowed) * priceDelay;
        }
        return charge;
    }

    @Override
    public int calculatePoints(int daysRented) {
        return points;
    }
}
