package com.fundacionjala.movies;

/**
 * Created by Charito on 6/10/2016.
 */
public class MovieNewRelease extends Movie {

    public MovieNewRelease(String title) {
        super(title);
        super.priceRent = 3;
        super.points = 1;
        super.daysAllowed = 1;
    }

    @Override
    public double calculateChargeMovie(int daysRented) {
        return daysRented * getPriceRent();
    }

    @Override
    public int calculatePoints(int daysRented) {
        int points = getPoints();
        if (daysRented > daysAllowed) {
            points++;
        }
        return points;
    }

}
