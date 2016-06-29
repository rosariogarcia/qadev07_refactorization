package com.fundacionjala.movies;

/**
 * @author RosarioGarcia
 * @inheritDoc
 */
public class MovieChildren extends Movie {

    private static final double PRICE_RENT = 1.5;
    private static final int DAYS_ALLOWED = 3;
    private static final double PRICE_DELAY = 1.5;

    /**
     * Constructor class that recive the Movie's title
     *
     * @param title Movie's title
     */
    public MovieChildren(String title) {
        super(title, PRICE_RENT, DAYS_ALLOWED, PRICE_DELAY);
    }
}
