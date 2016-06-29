package com.fundacionjala.movies;

/**
 * @author RosarioGarcia
 * @inheritDoc
 */
public class MovieRegular extends Movie {

    private static final double PRICE_RENT = 2;
    private static final int DAYS_ALLOWED = 2;
    private static final double PRICE_DELAY = 1.5;

    /**
     * Constructor class that receive the Movie's title
     *
     * @param title Movie's title
     */
    public MovieRegular(String title) {
        super(title, PRICE_RENT, DAYS_ALLOWED, PRICE_DELAY);
    }
}
