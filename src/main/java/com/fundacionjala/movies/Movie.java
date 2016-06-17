package com.fundacionjala.movies;

public abstract class Movie {

    protected static final int POINTS = 1;
    private final String title;
    private final double priceRent;
    private final double priceDelay;
    private final int daysAllowed;

    public Movie(String title, double priceRent, int daysAllowed, double priceDelay) {
        this.title = title;
        this.priceRent = priceRent;
        this.priceDelay = priceDelay;
        this.daysAllowed = daysAllowed;
    }

    public double calculateChargeMovie(int daysRented){
        double charge = getPriceRent();
        if (daysRented > getDaysAllowed()) {
            charge += (daysRented - getDaysAllowed()) * getPriceDelay();
        }
        return charge;
    }

    protected int calculatePoints(int daysRented){
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
