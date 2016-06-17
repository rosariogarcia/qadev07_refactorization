package com.fundacionjala.movies;

/**
 * Created by Charito on 6/10/2016.
 */
public class MovieRegular extends Movie {

    private static final double PRICE_RENT = 2;
    private static final int DAYS_ALLOWED = 2;
    private static final double PRICE_DELAY = 1.5;

    public MovieRegular(String title) {
        super(title, PRICE_RENT, DAYS_ALLOWED, PRICE_DELAY);
    }
}
