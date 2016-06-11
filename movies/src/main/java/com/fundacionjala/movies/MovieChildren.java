package com.fundacionjala.movies;

/**
 * Created by Charito on 6/10/2016.
 */
public class MovieChildren extends Movie {
    public static final int CHILDREN = 2;

    private static final double PRICE_RENT = 1.5;

    private static final int delay = 3;

    private static final double PRICE_DELAY = 1.5;

    private static final int POINTS = 1;


    public MovieChildren(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double calculateChargeMovie(int daysRented){
        double charge = PRICE_RENT;
        if (daysRented > delay)
            charge += (daysRented - delay) * PRICE_DELAY ;

        return charge;
    }

    @Override
    public int calculatePoints(int daysRented){
        return POINTS;
    }
}
