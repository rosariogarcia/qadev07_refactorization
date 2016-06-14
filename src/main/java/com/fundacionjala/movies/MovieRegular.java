package com.fundacionjala.movies;

/**
 * Created by Charito on 6/10/2016.
 */
public class MovieRegular extends Movie {

    public MovieRegular(String title) {
        super(title);
        super.priceRent = 2;
        super.daysAllowed = 2;
        super.priceDelay = 1.5;
        super.points = 1;
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
