package com.fundacionjala.movies;

/**
 * Created by Charito on 6/10/2016.
 */
public class MovieChildren extends Movie {

    public MovieChildren(String title) {
        super(title);
        super.priceRent = 1.5;
        super.daysAllowed = 3;
        super.priceDelay = 1.5;
        super.points = 1;
    }

    @Override
    public double calculateChargeMovie(int daysRented) {
        double charge = getPriceRent();
        if (daysRented > getDaysAllowed()) {
            charge += (daysRented - getDaysAllowed()) * getPriceDelay();
        }
        return charge;
    }

    @Override
    public int calculatePoints(int daysRented) {
        return getPoints();
    }
}
