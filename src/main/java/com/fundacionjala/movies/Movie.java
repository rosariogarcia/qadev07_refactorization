package com.fundacionjala.movies;

public abstract class Movie {

    protected static final int POINTS = 1;
    protected final String title;
    protected final double priceRent;
    protected final double priceDelay;
    protected final int daysAllowed;

    public Movie(String title, double priceRent, int daysAllowed, double priceDelay) {
        this.title = title;
        this.priceRent = priceRent;
        this.priceDelay = priceDelay;
        this.daysAllowed = daysAllowed;
    }

    public double calculateChargeMovie(int daysRented) {
        double charge = priceRent;
        if (daysRented > daysAllowed) {
            charge += (daysRented - daysAllowed) * priceDelay;
        }
        return charge;
    }

    protected int calculatePoints(int daysRented) {
        return POINTS;
    }

    public String getTitle() {
        return title;
    }

    public double getPriceRent() {
        return priceRent;
    }

    public double getPriceDelay() {
        return priceDelay;
    }

    public int getDaysAllowed() {
        return daysAllowed;
    }
}
