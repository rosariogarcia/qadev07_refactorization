package com.fundacionjala.movies;

public abstract class Movie {

    protected final String title;
    protected double priceRent;
    protected int daysAllowed;
    protected double priceDelay;
    protected int points;

    public Movie(String title) {
        this.title = title;
    }

    public abstract double calculateChargeMovie(int daysRented);

    public abstract int calculatePoints(int daysRented);

    public String getTitle() {
        return title;
    }

    public double getPriceRent() {
        return priceRent;
    }

    public int getDaysAllowed() {
        return daysAllowed;
    }

    public double getPriceDelay() {
        return priceDelay;
    }

    public int getPoints() {
        return points;
    }

}
