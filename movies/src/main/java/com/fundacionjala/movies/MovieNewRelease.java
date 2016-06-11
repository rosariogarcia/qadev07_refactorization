package com.fundacionjala.movies;

/**
 * Created by Charito on 6/10/2016.
 */
public class MovieNewRelease extends Movie {
    public static final int NEW_RELEASE = 1;

    private static final double PRICE_RENT = 3;

    private static final int POINTS = 1;

    public MovieNewRelease(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double calculateChargeMovie(int daysRented){
        return daysRented * PRICE_RENT;
    }

    @Override
    public int calculatePoints(int daysRented){
        int points = POINTS;
        if ( daysRented > 1)
            points++;
        return points;
    }

}
